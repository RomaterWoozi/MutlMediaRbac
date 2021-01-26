package com.wuzx.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;


/**
* @author WuZX
* 时间  2021/1/26 10:08
*  前后端分离
*/
@Slf4j
@Component
public class JwtManager {

    @Value("${security.jwt.secretKey}")
    private String secretKey="whenNever";

    private Duration expiration=Duration.ofDays(1);

    /**
    * @author WuZX
    * 时间  2021/1/26 9:49
    *  生成JWT  json web token 令牌
     *  JWT是由三段信息构成的，将这三段信息文本用.链接一起就构成了Jwt字符串
     *  header playload signature
    */
    public String generate(Long userId) {
        Date expiryDate=new Date(System.currentTimeMillis()+expiration.toMillis());
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)   //设置过期时间
                .signWith(SignatureAlgorithm.HS512,secretKey) //设置加密算法和密钥
                .compact();
    }

    /**
    * @author WuZX
    * 时间  2021/1/26 10:07
    *  jwt json web token 解析
     *
    */
    public Claims parse(String token){
        if(StringUtils.hasText(token)){
            return null;
        }
        Claims claims=null;

        try {
            claims=Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (JwtException e){
            log.error("token解析失败:{}",e.toString());
        }
        return claims;
    }

}

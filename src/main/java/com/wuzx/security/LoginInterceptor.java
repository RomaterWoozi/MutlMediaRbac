package com.wuzx.security;

import com.wuzx.enums.ResultCode;
import com.wuzx.exception.ApiException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author WuZX
* 时间  2021/1/26 10:54
* 访问拦截器，用来判断用户登陆状态
 * autowired 自动注入
*/
public class LoginInterceptor implements AsyncHandlerInterceptor {
    @Autowired
    private JwtManager jwtManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Claims claims=jwtManager.parse(request.getHeader("Authorization"));
        //如果用户已登录,直接放行
        if(claims!=null){
            // 将我们之前放到token中的userName给存到上下文对象中
            UserContext.add(Long.parseLong(claims.getSubject()));
            return true;
        }
        // 走到这代表没有登录
        throw new ApiException(ResultCode.UNAUTHORIZED);
//        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
              UserContext.remove();
    }
}

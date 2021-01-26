package com.wuzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuzx.exception.ApiException;
import com.wuzx.model.entity.LoginParam;
import com.wuzx.model.entity.User;
import com.wuzx.model.mapper.UserMapper;
import com.wuzx.model.vo.UserVO;
import com.wuzx.security.JwtManager;
import com.wuzx.service.ResourceService;
import com.wuzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private ResourceService resourceService;

    @Override
    public UserVO login(LoginParam loginParam) {
        User user=this.lambdaQuery()
                .eq(User::getUsername,loginParam.getUsername())
                .eq(User::getPassword,loginParam.getPassword())
                .one();
        if(user==null){
            throw new ApiException("账号或密码错误");
        }
        UserVO userVO=new UserVO();
        userVO.setId(user.getId()).setUsername(loginParam.getUsername())
                .setToken(jwtManager.generate(userVO.getId()))
                .setResourceIds(resourceService.getIdsByUserId(user.getId()));
        return userVO;
    }




}

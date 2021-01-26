package com.wuzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuzx.model.entity.LoginParam;
import com.wuzx.model.entity.User;
import com.wuzx.model.vo.UserVO;

public interface UserService extends IService<User> {

    /**
    * @author WuZX
    * 时间  2021/1/26 8:47
    * 登陆
    */
    UserVO login(LoginParam user);
}

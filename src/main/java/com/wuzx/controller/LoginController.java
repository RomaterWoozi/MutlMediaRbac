package com.wuzx.controller;

import com.wuzx.model.entity.LoginParam;
import com.wuzx.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wuzx.service.UserService;

@RestController
@RequestMapping("/API/login")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public UserVO login(@RequestBody @Validated LoginParam user){
		return userService.login(user);
	}





	

}

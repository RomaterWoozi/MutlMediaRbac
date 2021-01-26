package com.wuzx.controller;

import com.wuzx.login.model.entity.LoginParam;
import com.wuzx.login.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.wuzx.service.UserService;

@RestController
@RequestMapping("/API/login")
public class LoginController {
	
	@Autowired
	private UserService userService;

	/**
	* @author WuZX
	* 时间  2021/1/26 17:30
	 * @RequestBody @Validated
	*  Validator + 自动抛出异常
	*/
	@PostMapping
	public UserVO login(@RequestBody @Validated LoginParam user){
		System.out.println("LoginController login");
		return userService.login(user);
	}

	@GetMapping("api")
	public String api() {
		userService.doSomething();
		return "api成功返回数据";
	}





	

}

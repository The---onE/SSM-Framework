package xmx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xmx.service.IUserService;

/**
 * 前台控制器
 * 
 * @author The_onE
 *
 */
@Controller
@RequestMapping("/User")
public class UserController {
	/**
	 * 业务层
	 */
	@Resource
	private IUserService userService;
}

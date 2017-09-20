package xmx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xmx.service.IUserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Resource  
    private IUserService userService;
}

package xmx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import xmx.model.Admin;
import xmx.service.IAdminService;
import xmx.util.ObjectResult;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	/**
	 * Service层
	 */
	@Resource
	private IAdminService adminService;

	/**
	 * 后台首页，登录页
	 * @return 后台首页页面
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "admin/index";
	}

	/**
	 * 登录请求
	 * @param name 用户名
	 * @param pwd 密码
	 * @param session 当前Session
	 * @return 登录信息
	 */
	@RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(String name, String pwd, HttpSession session) {
		ObjectResult<Admin> result = new ObjectResult<>();
		Gson gson = new Gson();
		try {
			Admin admin = adminService.login(name, pwd);
			if (admin != null) {
				result.setStatus(1);
				result.setPrompt("登录成功");
				result.setObject(admin);
				
				session.setAttribute("admin", admin);
			} else {
				result.setStatus(0);
				result.setPrompt("用户名或密码错误");
			}
			return gson.toJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(0);
			result.setPrompt("登录失败");
			return gson.toJson(result);
		}
	}
	
	/**
	 * 后台主页
	 * @param session 当前Session
	 * @return 已登录返回后台主页界面，未登录返回登录界面
	 */
	@RequestMapping(value = "/main", produces = "text/html;charset=UTF-8")
	public String main(HttpSession session) {
		Object admin = session.getAttribute("admin");
		if (admin != null && admin instanceof Admin) {
			return "admin/main";
		} else {
			return "admin/index";
		}
	}
}

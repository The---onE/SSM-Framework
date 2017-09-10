package xmx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xmx.dao.AdminMapper;
import xmx.model.Admin;
import xmx.service.IAdminService;

@Service("adminService")
public class AdminService implements IAdminService {
	
	@Resource
	private AdminMapper adminDao;

	@Override
	public Admin login(String name, String pwd) {
		return adminDao.login(name, pwd);
	}
	
}

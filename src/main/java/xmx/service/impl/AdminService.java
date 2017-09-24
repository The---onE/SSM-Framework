package xmx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xmx.dao.AdminMapper;
import xmx.model.Admin;
import xmx.model.AdminExample;
import xmx.service.IAdminService;

/**
 * 管理员服务实现
 * 
 * @author The_onE
 *
 */
@Service("adminService")
public class AdminService implements IAdminService {

	@Resource
	private AdminMapper adminDao;

	@Override
	public Admin login(String username, String password) {
		// 根据用户名密码查询管理员
		AdminExample example = new AdminExample();
		example.or().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<Admin> admins = adminDao.selectByExample(example);
		if (admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;

		// return adminDao.selectByNamePwd(username, password);
	}

}

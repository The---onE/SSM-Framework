package xmx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xmx.dao.UserMapper;
import xmx.model.User;
import xmx.model.UserExample;
import xmx.service.IUserService;

/**
 * 用户服务实现
 * 
 * @author The_onE
 *
 */
@Service("userService")
public class UserService implements IUserService {

	@Resource
	private UserMapper userDao;

	@Override
	public User login(String name, String pwd) {
		// 根据用户名密码查询用户
		UserExample example = new UserExample();
		example.or().andUsernameEqualTo(name).andPasswordEqualTo(pwd);
		List<User> users = userDao.selectByExample(example);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public int register(User user) {
		// 根据用户名密码查询用户
		UserExample example = new UserExample();
		example.or().andUsernameEqualTo(user.getUsername());
		List<User> users = userDao.selectByExample(example);
		if (users != null && users.size() > 0) {
			// 该用户名已被注册
			return 0;
		}
		// 添加用户
		int re = userDao.insertSelective(user);
		if (re > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}

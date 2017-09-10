package xmx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xmx.dao.UserMapper;
import xmx.model.User;
import xmx.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	
	@Resource  
    private UserMapper userDao;
	
    @Override  
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);  
    }
}

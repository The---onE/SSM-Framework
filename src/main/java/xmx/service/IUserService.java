package xmx.service;

import xmx.model.User;

/**
 * 用户服务接口
 * 
 * @author The_onE
 *
 */
public interface IUserService {
	/**
	 * 通过用户ID获取用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return 用户信息
	 */
	public User getUserById(int userId);
}

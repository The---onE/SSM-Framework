package xmx.service;

import xmx.model.Admin;

public interface IAdminService {
	public Admin login(String name, String pwd);
}

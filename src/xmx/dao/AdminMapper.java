package xmx.dao;

import org.apache.ibatis.annotations.Param;

import xmx.model.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin login(@Param("name")String name, @Param("pwd")String pwd);
}
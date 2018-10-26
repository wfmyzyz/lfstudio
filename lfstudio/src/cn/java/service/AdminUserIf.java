package cn.java.service;

import java.util.List;

import cn.java.entity.AdminUser;

public interface AdminUserIf {
	/**
	 * 	查询所有工作人员
	*/
	List<AdminUser> selectAll();
	
	/**
	 * 	登录查询管理员信息
	 */
	AdminUser selectByUserPass(AdminUser record);
	
	/**
	 *	 增加管理员
	 */
	int insert(AdminUser record);
	
	/**
	 * 删除管理员
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 	修改管理员信息
	 */
	int updateByPrimaryKey(AdminUser record);
	
	/**
	 * 	查询一个管理员
	 */
	AdminUser selectByPrimaryKey(Integer id);
	
	/**
	 * 是否存在改管理员
	 */
	 AdminUser selectadminif(String name);
}

package cn.java.service;

import java.util.List;

import cn.java.entity.AdminUser;

public interface AdminUserIf {
	/**
	 * 	��ѯ���й�����Ա
	*/
	List<AdminUser> selectAll();
	
	/**
	 * 	��¼��ѯ����Ա��Ϣ
	 */
	AdminUser selectByUserPass(AdminUser record);
	
	/**
	 *	 ���ӹ���Ա
	 */
	int insert(AdminUser record);
	
	/**
	 * ɾ������Ա
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 	�޸Ĺ���Ա��Ϣ
	 */
	int updateByPrimaryKey(AdminUser record);
	
	/**
	 * 	��ѯһ������Ա
	 */
	AdminUser selectByPrimaryKey(Integer id);
	
	/**
	 * �Ƿ���ڸĹ���Ա
	 */
	 AdminUser selectadminif(String name);
}

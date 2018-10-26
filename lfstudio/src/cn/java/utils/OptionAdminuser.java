package cn.java.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.AdminUser;
import cn.java.service.impl.AdminUserIfImpl;

@Component
public class OptionAdminuser {
	
	@Autowired
	AdminUserIfImpl adminUserIfImpl;
	
	/**
	 * 	���ӹ���Ա
	 * @return
	 */
	@Transactional
	public int insertadminuser(AdminUser record) {
		int back = adminUserIfImpl.insert(record);
		return back;
	}
	
	/**
	 *	 ɾ������Ա
	 * @param id
	 * @return
	 */
	@Transactional
	public int deleteadminuser(int id) {
		int back = adminUserIfImpl.deleteByPrimaryKey(id);
		return back;
	}
	
	/**
	 * 	�޸Ĺ���Ա
	 */
	@Transactional
	public int updateadminuser(AdminUser record) {
		int back = adminUserIfImpl.updateByPrimaryKey(record);
		return back;
	}
}

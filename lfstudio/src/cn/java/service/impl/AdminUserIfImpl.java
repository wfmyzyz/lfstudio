package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.dao.admin.AdminUserMapper;
import cn.java.entity.AdminUser;
import cn.java.service.AdminUserIf;

@Service
public class AdminUserIfImpl implements AdminUserIf{
	@Autowired
	private AdminUserMapper adminUserMapper;
	@Override
	public List<AdminUser> selectAll() {
		// TODO Auto-generated method stub
		return adminUserMapper.selectAll();
	}
	@Override
	public AdminUser selectByUserPass(AdminUser record) {
		// TODO Auto-generated method stub
		return adminUserMapper.selectByUserPass(record);
	}
	@Override
	public int insert(AdminUser record) {
		// TODO Auto-generated method stub
		return adminUserMapper.insert(record);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return adminUserMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKey(AdminUser record) {
		// TODO Auto-generated method stub
		return adminUserMapper.updateByPrimaryKey(record);
	}
	@Override
	public AdminUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return adminUserMapper.selectByPrimaryKey(id);
	}
	@Override
	public AdminUser selectadminif(String name) {
		// TODO Auto-generated method stub
		return adminUserMapper.selectadminif(name);
	}

}

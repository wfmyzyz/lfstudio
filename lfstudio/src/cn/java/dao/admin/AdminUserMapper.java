package cn.java.dao.admin;


import java.util.List;

import cn.java.entity.AdminUser;

public interface AdminUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbg.generated Sun Oct 14 23:45:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbg.generated Sun Oct 14 23:45:50 CST 2018
     */
    int insert(AdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbg.generated Sun Oct 14 23:45:50 CST 2018
     */
    AdminUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbg.generated Sun Oct 14 23:45:50 CST 2018
     */
    List<AdminUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbg.generated Sun Oct 14 23:45:50 CST 2018
     */
    int updateByPrimaryKey(AdminUser record);
    
    /**
     * 	����Ա��¼��̨����
     * 
     */
    AdminUser selectByUserPass(AdminUser record);
    
    /**
     * ��ѯ����Ա�Ƿ����
     */
    AdminUser selectadminif(String name);
}
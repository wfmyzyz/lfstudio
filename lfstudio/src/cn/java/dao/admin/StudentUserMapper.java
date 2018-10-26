package cn.java.dao.admin;

import java.util.List;

import cn.java.entity.AdminUser;
import cn.java.entity.StudentUser;

public interface StudentUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_user
     *
     * @mbg.generated Sun Oct 21 23:25:06 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_user
     *
     * @mbg.generated Sun Oct 21 23:25:06 CST 2018
     */
    int insert(StudentUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_user
     *
     * @mbg.generated Sun Oct 21 23:25:06 CST 2018
     */
    StudentUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_user
     *
     * @mbg.generated Sun Oct 21 23:25:06 CST 2018
     */
    List<StudentUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_user
     *
     * @mbg.generated Sun Oct 21 23:25:06 CST 2018
     */
    int updateByPrimaryKey(StudentUser record);
    
    /**
     * 	��ѯѧ���˺��Ƿ����
     */
    StudentUser selectadminif(String name);
    
    /**
     * 	����ѧ��ģ����ѯѧ��
     */
    List<StudentUser> selectlikeAll(String name);
}
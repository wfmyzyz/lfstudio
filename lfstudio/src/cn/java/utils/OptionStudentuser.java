package cn.java.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.StudentPerson;
import cn.java.entity.StudentUser;
import cn.java.service.impl.DormitoryRoomManNumIfImpl;
import cn.java.service.impl.StudentPersonIfImpl;
import cn.java.service.impl.StudentUserIfImpl;

@Component
public class OptionStudentuser {
	@Autowired
	StudentUserIfImpl studentUserIfImpl;
	@Autowired
	StudentPersonIfImpl studentPersonIfImpl;
	@Autowired
	DormitoryRoomManNumIfImpl dormitoryRoomManNumIfImpl;
	/**
	 * 	���ӹ���Ա
	 * @return
	 */
	@Transactional
	public int insertadminuser(StudentUser record) {
		int back = studentUserIfImpl.insert(record);
		return back;
	}
	
	/**
	 *	 ɾ������Ա
	 * @param id
	 * @return
	 */
	@Transactional
	public int deleteadminuser(int id,String pid) {
		int back;
		int back1 = studentPersonIfImpl.deleteonebyid(pid);
		int back2 = studentUserIfImpl.deleteByPrimaryKey(id);
		if(back1==1&&back2==1) {
			back = 1;
		}else {
			back = 0;
		}
		return back;
	}
	
	/**
	 * 	�޸Ĺ���Ա
	 */
	@Transactional
	public int updateadminuser(StudentUser record) {
		int back = studentUserIfImpl.updateByPrimaryKey(record);
		return back;
	}
	
	/**
	 * 	�޸�ѧ����Ϣ
	 * @param record
	 * @return
	 */
	@Transactional
	public int updatestudentuser(StudentPerson record) {
		int back = studentPersonIfImpl.updateonebyid(record);
		return back;
	}
	
	/**
	 * 	����ѧ����Ϣ
	 */
	@Transactional
	public int insertstudentuser(StudentPerson record) {
		int back = studentPersonIfImpl.insert(record);
		return back;
	}
	
	/**
	 * 	����ѧ��ɾ��ѧ����Ϣ
	 */
	@Transactional
	public int deletestudentbypid(String id) {
		int back = studentPersonIfImpl.deleteonebyid(id);
		return back;
	}
	
	/**
	 * 	�����Ƴ�����ѧ��
	 */
	@Transactional
	public int updatemoreroom(List<StudentPerson> list,Integer room) {
		int back = studentPersonIfImpl.updatemoreroom(list);
		for(StudentPerson lists : list) {
			dormitoryRoomManNumIfImpl.subnum(room);
		}
		return back;
		
	}
}

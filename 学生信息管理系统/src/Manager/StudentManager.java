package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Student;

/**
 * ѧ����ҵ��
 */
public class StudentManager {
	
	// ���
	public static boolean add(Student student) {
		if(DataBase.getStudents().containsKey(student.getUsername())){
			return false;
		}
		else{
			DataBase.getStudents().put(student.getUsername(), student);
			return true;
		}
		
	}

	// ɾ��
	public static void del(String username) {
		DataBase.getStudents().remove(username);
	}

	// ��
	public static void update(Student student) {
		DataBase.getStudents().put(student.getUsername(), student);
	}

	// ������
	public static List<Student> find() {
		Map<String, Student> stus = DataBase.getStudents();
		Set<String> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < objs.length; i++) {
			String sid = (String) (objs[i]);
			list.add(stus.get(sid));
		}
		return list;
	}

	// ��һ��
	public static Student findByUserName(String username) {
		return DataBase.getStudents().get(username);
	}

	// ��¼
	public static boolean login(String username,String password){
		Student stu=DataBase.getStudents().get(username);
		try {
			if(password.equals(stu.getPassword())){
				//��¼�ɹ�
				DataBase.getRequest().put("login", stu);
				return true;
			}
			else{
				//��¼ʧ��
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
}


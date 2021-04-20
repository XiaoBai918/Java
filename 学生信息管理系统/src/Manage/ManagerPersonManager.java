package Manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.ManagerPerson;

/**
 * ����Ա��ҵ����
 *
 */
public class ManagerPersonManager {


	// ���
	public static boolean add(ManagerPerson ManagerPerson) {
		if(DataBase.getManagerPersons().containsKey(ManagerPerson.getUsername())){
			return false;
		}
		else{
			DataBase.getManagerPersons().put(ManagerPerson.getUsername(), ManagerPerson);
			return true;
		}	
		
	}

	// ɾ��
	public static void del(String username) {
		DataBase.getManagerPersons().remove(username);
	}

	// ��
	public static void update(ManagerPerson ManagerPerson) {
		DataBase.getManagerPersons().put(ManagerPerson.getUsername(), ManagerPerson);
	}

	// ������
	public static List<ManagerPerson> find() {
		Map<String, ManagerPerson> stus = DataBase.getManagerPersons();
		Set<String> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		List<ManagerPerson> list = new ArrayList<ManagerPerson>();
		for (int i = 0; i < objs.length; i++) {
			String sid = (String) (objs[i]);
			list.add(stus.get(sid));
		}
		return list;
	}

	// ��һ��
	public static ManagerPerson findByUserName(String username) {
		return DataBase.getManagerPersons().get(username);
	}

	// ��¼
	public static boolean login(String username, String password) {
		try {
			ManagerPerson stu = DataBase.getManagerPersons().get(username);
			if (password.equals(stu.getPassword())) {
				// ��¼�ɹ�
				DataBase.getRequest().put("login", stu);
				return true;
			} else {
				// ��¼ʧ��
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
}



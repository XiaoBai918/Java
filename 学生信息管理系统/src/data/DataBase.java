package data;

import java.util.HashMap;
import java.util.Map;

import pojo.Course;
import pojo.ManagerPerson;
import pojo.Student;


public class DataBase {
	private static Map<String,Object> request=new HashMap<>();//�洢һЩ����
	private static Map<String,Student> students=new HashMap<>();//ѧ��������
	private static Map<String,ManagerPerson> managerPersons=new HashMap<>();//����Ա������
	private static Map<String,Course> courses=new HashMap<>();//�γ̵�����
	public static Map<String, Student> getStudents() {
		return students;
	}
	public static void setStudents(Map<String, Student> students) {
		DataBase.students = students;
	}
	public static Map<String, ManagerPerson> getManagerPersons() {
		return managerPersons;
	}
	public static void setManagerPersons(Map<String, ManagerPerson> managerPersons) {
		DataBase.managerPersons = managerPersons;
	}
	public static Map<String, Course> getCourses() {
		return courses;
	}
	public static void setCourses(Map<String, Course> courses) {
		DataBase.courses = courses;
	}
	public static Map<String, Object> getRequest() {
		return request;
	}
	public static void setRequest(Map<String, Object> request) {
		DataBase.request = request;
	}}


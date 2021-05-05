package manager;

import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Course;

/**
 * �ɼ���ҵ��
 * 
 */
public class GradeManager {
	/**
	 * ���ӳɼ�
	 * 
	 * @param username
	 *            �û���
	 * @param courseId
	 *            �γ̵�id
	 * @param result
	 *            ����
	 */
	public static boolean add(String username, String courseId, double result) {

		try {
			Course course = DataBase.getCourses().get(courseId);
			if (course != null) {
				if (DataBase.getStudents().get(username).getResults().containsKey(course)) {
					return false;
				} else {
					DataBase.getStudents().get(username).getResults().put(course, result);
					return true;
				}

			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * ɾ��ѧ���ĳɼ�
	 * 
	 * @param username
	 *            �û���
	 * @param courseId
	 *            �γ̵�id
	 */
	public static void del(String username, String courseId) {
		Course course = DataBase.getCourses().get(courseId);
		DataBase.getStudents().get(username).getResults().remove(course);
	}

	/**
	 * �޸��û��ĳɼ�
	 * 
	 * @param username
	 *            �û���
	 * @param courseId
	 *            �γ̵�id
	 * @param result
	 *            �ɼ�����
	 */
	public static boolean update(String username, String courseId, double result) {
		Course course = DataBase.getCourses().get(courseId);
		if(DataBase.getStudents().get("username").getResults().containsKey(course)){
			DataBase.getStudents().get(username).getResults().put(course, result);
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * ��,��ʾ�γ̵�id�Ϳγ̵����֣��ͳɼ�
	 * 
	 * @param username
	 *            ��ѯ���û����û���
	 */
	public static String[][] find(String username) {
		Map<Course, Double> stus = DataBase.getStudents().get(username).getResults();
		Set<Course> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		Course[] courses = new Course[objs.length];
		for (int i = 0; i < objs.length; i++) {
			courses[i] = (Course) objs[i];
		}
		String[][] result = new String[objs.length][3];
		for (int i = 0; i < objs.length; i++) {

			result[i][0] = courses[i].getId();
			result[i][1] = courses[i].getName();
			result[i][2] = stus.get(courses[i]) + "";
		}
		return result;
	}
}



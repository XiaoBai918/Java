package Manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Course;

/**
 * �γ̵�ҵ����
 *
 */
public class CourseManager {

	//��
	public static boolean add(Course course){
		if(DataBase.getCourses().containsKey(course.getId())){
			return false;
		}
		else{
			DataBase.getCourses().put(course.getId(), course);
			return true;
		}
		
	}
	

	
	//��
	public static void update(Course course){
		DataBase.getCourses().put(course.getId(), course);
	}
	
	//��
	public static List<Course> find(){
		Map<String, Course> stus = DataBase.getCourses();
		Set<String> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		List<Course> list = new ArrayList<Course>();
		for (int i = 0; i < objs.length; i++) {
			String sid = (String) (objs[i]);
			list.add(stus.get(sid));
		}
		return list;
	}
	
	/**
	 * ���ؿγ̵���Ϣ
	 * @param id �γ̵�id
	 * @return ���صĿγ̵���Ϣ���������Ŀγ̵�idû�в鵽�����ؿ�
	 */
	public static Course find(String id){
		return DataBase.getCourses().get(id);
	}
}


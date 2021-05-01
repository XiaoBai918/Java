package view;

import java.util.List;

import pojo.Course;
import manager.CourseManager;
import tools.Tools;

public class CourseView {

	/**
	 * ���һ���γ�
	 */
	public static void add() {
		// ������γ̵ı��
		System.out.println("������γ̵ı�ţ�");
		Course course = new Course();
		course.setId(Tools.scanner.next());
		System.out.println("������γ̵����֣�");
		course.setName(Tools.scanner.next());

		if (CourseManager.add(course)) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ�ܣ��γ̵ı�ſ����Ѿ�����");
		}

	}

	/**
	 * �޸Ŀγ̵���Ϣ
	 */
	public static void update() {
		// ������γ̵ı��
		System.out.println("������γ̵ı�ţ�");
		Course course = CourseManager.find(Tools.scanner.next());
		if (course == null) {
			System.out.println("����Ŀγ̲鲻�������֤������");
		} else {
			System.out.println("�������µĿγ̵����֣�");
			course.setName(Tools.scanner.next());
			System.out.println("�޸ĳɹ�");
		}
	}

	/**
	 * �������пγ̵���Ϣ
	 */
	public static void find() {
		List<Course> list = CourseManager.find();
		for (Course course : list) {
			System.out.println(course);
		}
	}
	
	
	/**
	 * ��ѯָ���Ŀγ̵���Ϣ
	 */
	public static Course findById(String id) {
		Course course = CourseManager.find(id);
		if (course == null) {
			System.out.println("����Ŀγ̲鲻�������֤������");
		} else {
			System.out.println(course);
		}
		return course;
	}

	/**
	 * ��ѯָ���Ŀγ̵���Ϣ
	 */
	public static void findById() {
		// ������γ̵ı��
		System.out.println("������γ̵ı�ţ�");
		Course course = CourseManager.find(Tools.scanner.next());
		if (course == null) {
			System.out.println("����Ŀγ̲鲻�������֤������");
		} else {
			System.out.println(course);
		}
	}
}



package view;

import java.util.List;

import pojo.Student;
import manager.GradeManager;
import manager.StudentManager;
import tools.Tools;

public class GradeView {

	/**
	 * ����һ���ɼ�
	 */
	public static void add() {
		System.out.println("������Ҫ��ӳɼ����û�����");
		String username = Tools.scanner.next();
		System.out.println("������γ̵ı�ţ�");
		String code = Tools.scanner.next();
		System.out.println("�����������");
		double result = Tools.getDouble(Tools.scanner.next(), 0);
		try {
			if (GradeManager.add(username, code, result)) {
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ�ܣ����������Ϣ����");
			}

		} catch (Exception e) {
			System.out.println("���ʧ�ܣ����������Ϣ����");
		}
	}

	/**
	 * ɾ���û��ĳɼ�
	 */
	public static void del() {
		System.out.println("������Ҫɾ���ɼ����û�����");
		String username = Tools.scanner.next();
		System.out.println("������γ̵ı�ţ�");
		String code = Tools.scanner.next();
		try {
			GradeManager.del(username, code);
			System.out.println("ɾ���ɹ�");
		} catch (Exception e) {
			System.out.println("ɾ��ʧ�ܡ����������Ϣ����");
		}
	}

	/**
	 * �޸��û��ĳɼ�
	 */
	public static void update() {
		System.out.println("������Ҫ�޸ĳɼ����û�����");
		String username = Tools.scanner.next();
		System.out.println("������γ̵ı�ţ�");
		String code = Tools.scanner.next();
		System.out.println("�������µķ�����");
		double result = Tools.getDouble(Tools.scanner.next(), 0);
		try {
			if(GradeManager.update(username, code, result)){
				System.out.println("�޸ĳɹ�");
			}
			else{
				System.out.println("�޸�ʧ�ܣ����ܳɼ���Ϣ������");
			}
		} catch (Exception e) {
			System.out.println("�޸�ʧ�ܣ����������Ϣ����");
		}
	}

	/**
	 * ��ѯָ���û��ĳɼ�
	 */
	public static void find() {
		System.out.println("������Ҫ��ѯ�ɼ����û�����");
		String username = Tools.scanner.next();
		try {
			Student student = StudentManager.findByUserName(username);
			String[][] result = GradeManager.find(username);

			for (int i = 0; i < result.length; i++) {
				System.out.println("�û��˻���" + student.getUsername() + "������" + student.getName() + ":�γ̱�ţ�" + result[i][0]
						+ "�γ����ƣ�" + result[i][1] + "�ɼ���" + result[i][2]);
			}

		} catch (Exception e) {
			System.out.println("��ѯʧ�ܣ����������Ϣ����");
		}
	}

	/**
	 * ��ѯָ���û��ĳɼ�
	 */
	public static void find(String username) {
		try {
			Student student = StudentManager.findByUserName(username);
			String[][] result = GradeManager.find(username);

			for (int i = 0; i < result.length; i++) {
				System.out.println("�û��˻���" + student.getUsername() + "������" + student.getName() + ":�γ̱�ţ�" + result[i][0]
						+ "�γ����ƣ�" + result[i][1] + "�ɼ���" + result[i][2]);
			}

		} catch (Exception e) {
			System.out.println("��ѯʧ�ܣ����������Ϣ����");
		}
	}

	/**
	 * ��ѯ�����û��ĳɼ�
	 */
	public static void findAll() {
		List<Student> list = StudentManager.find();

		try {
			for (int i = 0; i < list.size(); i++) {
				Student student = list.get(i);
				String[][] result = GradeManager.find(student.getUsername());

				for (int j = 0; j < result.length; j++) {
					System.out.println("�û��˻���" + student.getUsername() + "������" + student.getName() + ":�γ̱�ţ�"
							+ result[j][0] + "�γ����ƣ�" + result[j][1] + "�ɼ���" + result[j][2]);
				}
			}

		} catch (Exception e) {
			System.out.println("��ѯʧ��");
		}

	}
}



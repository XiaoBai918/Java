package view;

import java.util.Date;
import java.util.List;

import data.DataBase;
import pojo.Student;
import manager.StudentManager;
import tools.Tools;

/**
 * ѧ���Ľ�������
*/
public class StudentView {
/**
	 * �û���¼
	 * @return
	 */
	public static boolean login(){
		System.out.println("������ѧ�����˻���");
		String username=Tools.scanner.next();
		System.out.println("������ѧ�������룺");
		String password=Tools.scanner.next();
		//�ж��Ƿ��¼�ɹ�������ɹ�����¼�û�����Ϣ��ŵ�request login��
		return StudentManager.login(username, password);
	}
	/**
	 * ����һ��ѧ��
	 */
	public static void add() {
		// �½�һ��ѧ���Ķ���
		Student student = new Student();
		// ��Ӵ����û���ʱ��
		student.setCreateDate(new Date());
		System.out.println("�������û����˻���");
		student.setUsername(Tools.scanner.next());
		System.out.println("�������û������룺");
		student.setPassword(Tools.scanner.next());
		System.out.println("�������û���������");
		student.setName(Tools.scanner.next());
		System.out.println("��ѡ���û����Ա�");
		System.out.println("0��Ů��  1���У�  2������");

		// �����û����Ա𣬲��������ݵ�У��
		int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
		student.setSex(sex > 2 ? 2 : sex);

		System.out.println("�������û����䣺");
		student.setAge(Tools.getInteger(Tools.scanner.next(), 0));
		student.setCreateDate(new Date());// ����û���ʱ��
		System.out.println("�������û��ĵ�ַ��");
		student.setAddress(Tools.scanner.next());

		if(StudentManager.add(student)){
			System.out.println("��ӳɹ�");
		}
		else{
			System.out.println("���ʧ�ܣ��������Ϣ���󣬻����û���ѧ���ظ�");
		}
		
	}

	/**
	 * ɾ��һ��ѧ��
	 */
	public static void del() {
		System.out.println("�������û����˻���");
		String username = Tools.scanner.next();
		Student student = StudentManager.findByUserName(username);
		if (student == null) {
			System.out.println("ɾ�����û�������");
		} else {
			StudentManager.del(username);
			System.out.println("ɾ���ɹ�");
		}
	}
	
	/**
	 * ����һ���û�
	 */
	public static void findByUsername(){
		System.out.println("�������û���ѧ�ţ�");
		String username=Tools.scanner.next();
		Student student= StudentManager.findByUserName(username);
		if(student==null){
			System.out.println("�������ѧ���Ҳ���");
		}
		else{
			System.out.println(student);
		}
	}
	
	
	
	/**
	 * �������е��û�
	 */
	public static void find(){
		List<Student> list= StudentManager.find();
		for (Student student : list) {
			System.out.println(student);
		}
	}
		/**
	 * �û��޸��Լ�������
	 */
	public static void updatePwd() {
		Student student = StudentManager.findByUserName(((Student)DataBase.getRequest().get("login")).getUsername());
		if (student == null) {
			System.out.println("Ҫ�޸ĵ��û�������");
		} else {

			System.out.println("�û��������ǣ�*****" );
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("�������û������룺");
				student.setPassword(Tools.scanner.next());
			}
			System.out.println("�޸ĳɹ�");
		}
	}
	/**
	 * �޸��û�����Ϣ,�������е���Ϣ
	 */
	public static void update() {
		System.out.println("�������û����˻���");
		String username = Tools.scanner.next();
		Student student = StudentManager.findByUserName(username);
		if (student == null) {
			System.out.println("Ҫ�޸ĵ��û�������");
		} else {
			System.out.println("�û��������ǣ�" + student.getName());
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("�������û���������");
				student.setName(Tools.scanner.next());
			}

			System.out.println("�û��������ǣ�*****" );
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("�������û������룺");
				student.setPassword(Tools.scanner.next());
			}

			System.out.println("�û����Ա��ǣ�" + Tools.getSex(student.getSex()));
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("��ѡ���û����Ա�");
				System.out.println("0��Ů��  1���У�  2������");

				// �����û����Ա𣬲��������ݵ�У��
				int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
				student.setSex(sex > 2 ? 2 : sex);
			}

			System.out.println("�û��������ǣ�" + student.getAge());
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("�������û������䣺");
				student.setAge(Tools.getInteger(Tools.scanner.next(), 0));
			}

			System.out.println("�û��ĵ�ַ�ǣ�" + student.getAddress());
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("�������û��ĵ�ַ��");
				student.setAddress(Tools.scanner.next());
			}
			System.out.println("�޸ĳɹ�");
		}
	}
}



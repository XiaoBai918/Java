package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Course;
import pojo.ManagerPerson;
import pojo.Student;
import view.CourseView;
public class Stulint {
public static void start() {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		File file = new File(Stulint.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "StuManagerConfig.ini");

		if (file.exists()) {
			// �����ļ����ڣ���ȡ
			System.out.println("���ڶ�ȡ����...");
			String courseStr = "";
			String managerPersonStr = "";
			String studentsStr = "";
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				courseStr = bufferedReader.readLine();// �γ���Ϣ�Ķ�ȡ
				managerPersonStr = bufferedReader.readLine();// ������Ϣ�Ķ�ȡ
				studentsStr = bufferedReader.readLine();// �û���Ϣ�Ķ�ȡ

			} catch (Exception e) {
				System.out.println("���ݱ��ƻ������ܶ�ȡ����ɾ����������");
			} finally {
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e) {
					System.out.println("���ݶ�ȡ�쳣�����ݿ����Ѿ����ƻ�");
					e.printStackTrace();
				}

			}


			// ��ʼ���γ�
			setCourses(courseStr);

			// ��ʼ������Ա
			setManagerPersons(managerPersonStr);

			// ��ʼ���û�
			setStudents(studentsStr);

		} else {
			// �����ڣ���ʼ������Ա
			ManagerPerson person = new ManagerPerson();
			person.setUsername("admin");
			person.setPassword("admin");
			person.setName("����");
			person.setCreateDate(new Date());
			person.setSex(1);
			person.setAge(20);
			person.setRank(0);
			person.setAddress("����ʡ");
			DataBase.getManagerPersons().put(person.getUsername(), person);
		}
	}

	/**
	 * ���������ʱ�򱣴�����
	 */
	public static void stop() {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		File file = new File(Stulint.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "StuManagerConfig.ini");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("�����ļ�����ʧ��");
				e.printStackTrace();
			}
		}

		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);

			// д��γ̵���Ϣ
			bufferedWriter.write(getCourses());
			bufferedWriter.newLine();

			// д�����Ա����Ϣ
			bufferedWriter.write(getManagerPersons());
			bufferedWriter.newLine();

			// д��ѧ������Ϣ
			bufferedWriter.write(getStudents());

		} catch (IOException e) {
			System.out.println("���ݱ���ʧ�ܣ����ܳ����쳣");
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("���ݱ�������쳣�����ݿ�����");
				e.printStackTrace();
			}

		}

	}

	/**
	 * ��֯�γ̵���Ϣ
	 * 
	 * @return
	 */
	public static String getCourses() {
		String string = "{";
		Set<String> set = DataBase.getCourses().keySet();

		Object[] objects = set.toArray();
		for (int i = 0; i < objects.length; i++) {
			String id = (String) objects[i];
			Course course = DataBase.getCourses().get(id);
			string = string + "<" + course.getId() + ":" + course.getName() + ">";
			if (i != objects.length - 1) {
				string += "��";
			}
		}
		string += "}";
		return string;
	}
	
	/**
	 * ��ʼ��ѧ������Ϣ
	 * @param string
	 */
	public static void setStudents(String string){

		//ȥ�����ߵ�{}
		string = string.substring(1, string.length() - 1);
		if (string.length() != 0) {
			
			// �ֱ�ȡ��ÿ��ѧ��
			String[] strings = string.split("��");

			// ����ÿ��ѧ��
			for (int i = 0; i < strings.length; i++) {

				// ȡ��һ��ѧ��
				String oneStudent = strings[i];


				// ȥ��ѧ����<>
				oneStudent = oneStudent.substring(1, oneStudent.length() - 1);


				// �ָ���Ϣ
				String[] oneStudentSplit = oneStudent.split(",");

				// �½�һ���γ�
				Student student = new Student();

				//�����˻�
				student.setUsername(oneStudentSplit[0]);
				student.setPassword(oneStudentSplit[1]);
				student.setName(oneStudentSplit[2]);
				student.setSex(Tools.getInteger(oneStudentSplit[3], 1));
				student.setAge(Tools.getInteger(oneStudentSplit[4], 0));
				student.setCreateDate(Tools.getDate(oneStudentSplit[5]));
				student.setAddress(oneStudentSplit[6]);
				
				
				//ѧ���ĳɼ�
				if(oneStudentSplit.length>7){
					//�гɼ�����Ϣ
					String resultStr=oneStudentSplit[7];
					
					//�ָ�ɼ�
					
					String[] results=resultStr.split("\\|");
					
					for(int j=0;j<results.length;j++){
						//�м����ɼ�
						
						String[] oneResult=results[j].split(":");
						//���ݱ�Ų�γ�
						Course course=CourseView.findById(oneResult[0]);
						student.getResults().put(course, Tools.getDouble(oneResult[1], 0));
					}
				}
				
				

				// �洢
				DataBase.getStudents().put(student.getUsername(), student);
				
			

			}
		} else {
			// ��ѧ����Ϣ
			System.out.println("û��ѧ����Ϣ������...");
		}
	}
	
	/**
	 * ��ʼ������Ա����Ϣ
	 * @param string
	 */
	public static void setManagerPersons(String string){

		//ȥ�����ߵ�{}
		string = string.substring(1, string.length() - 1);
		if (string.length() != 0) {
			
			// �ֱ�ȡ��ÿ������Ա
			String[] strings = string.split("��");

			// ����ÿ������Ա
			for (int i = 0; i < strings.length; i++) {

				// ȡ��һ������Ա
				String oneManagerPerson = strings[i];


				// ȥ������Ա��<>
				oneManagerPerson = oneManagerPerson.substring(1, oneManagerPerson.length() - 1);


				// �ָ�id������
				String[] oneManagerPersonSplit = oneManagerPerson.split(",");

				// �½�һ���γ�
				ManagerPerson managerPerson = new ManagerPerson();

				//�����˻�
				managerPerson.setUsername(oneManagerPersonSplit[0]);
				managerPerson.setPassword(oneManagerPersonSplit[1]);
				managerPerson.setName(oneManagerPersonSplit[2]);
				managerPerson.setSex(Tools.getInteger(oneManagerPersonSplit[3], 1));
				managerPerson.setAge(Tools.getInteger(oneManagerPersonSplit[4], 0));
				managerPerson.setCreateDate(Tools.getDate(oneManagerPersonSplit[5]));
				managerPerson.setAddress(oneManagerPersonSplit[6]);
				managerPerson.setRank(Tools.getInteger(oneManagerPersonSplit[7], 1));
				
				

				// �洢
				DataBase.getManagerPersons().put(managerPerson.getUsername(), managerPerson);
				
				

			}
		} else {
			// �޹���Ա��Ϣ
			System.out.println("û�й���Ա��Ϣ������...");
		}
	}

	/**
	 * ��ʼ���γ̵���Ϣ
	 * 
	 * @param
	 */
	public static void setCourses(String string) {
		
		//ȥ�����ߵ�{}
		string = string.substring(1, string.length() - 1);
		if (string.length() != 0) {
			

			
			// �ֱ�ȡ��ÿ���γ�
			String[] strings = string.split("��");

			// ����ÿ���γ�
			for (int i = 0; i < strings.length; i++) {

				// ȡ��һ���γ�
				String oneCourse = strings[i];


				// ȥ���γ̵�<>
				oneCourse = oneCourse.substring(1, oneCourse.length() - 1);


				// �ָ�id������
				String[] onCourseSplit = oneCourse.split(":");

				// �½�һ���γ�
				Course course = new Course();

				// ����id
				course.setId(onCourseSplit[0]);

				// ��������
				course.setName(onCourseSplit[1]);

				// �洢
				DataBase.getCourses().put(course.getId(), course);

			}
		} else {
			// �޿γ���Ϣ
			System.out.println("û�пγ���Ϣ������...");
		}
	}

	/**
	 * ��֯����Ա����Ϣ
	 * 
	 * @return
	 */
	public static String getManagerPersons() {
		String string = "{";
		Set<String> set = DataBase.getManagerPersons().keySet();
		Object[] objects = set.toArray();

		for (int i = 0; i < objects.length; i++) {
			String id = (String) objects[i];
			ManagerPerson managerPerson = DataBase.getManagerPersons().get(id);
			string = string + "<" + managerPerson.getUsername() + "," + managerPerson.getPassword() + ","
					+ managerPerson.getName() + "," + managerPerson.getSex() + "," + managerPerson.getAge() + ","
					+ managerPerson.getCreateDate() + "," + managerPerson.getAddress() + "," + managerPerson.getRank()
					+ ">";
			if (i != objects.length - 1) {
				string += "��";
			}
		}
		string += "}";
		return string;

	}

	/**
	 * ��֯ѧ������Ϣ
	 * 
	 * @return
	 */
	public static String getStudents() {
		String string = "{";

		Set<String> set = DataBase.getStudents().keySet();
		Object[] objects = set.toArray();

		for (int i = 0; i < objects.length; i++) {
			String id = (String) objects[i];
			Student student = DataBase.getStudents().get(id);
			string = string + "<" + student.getUsername() + "," + student.getPassword() + "," + student.getName() + ","
					+ student.getSex() + "," + student.getAge() + "," + student.getCreateDate() + ","
					+ student.getAddress();

			// ѧ���ĳɼ�
			Map<Course, Double> map = student.getResults();

			if (!map.isEmpty()) {
				// ���ǿյ�
				string += ",";
				Set<Course> courses = map.keySet();
				Object[] objs = courses.toArray();
				for (int j = 0; j < objs.length; j++) {
					Course course = (Course) objs[j];
					string += course.getId() + ":" + map.get(course);
					if (j != objs.length - 1) {
						string += "|";
					}
				}
			}
			string += ">";

			if (i != objects.length - 1) {
				string += "��";
			}
		}

		string += "}";
		return string;
	}

}



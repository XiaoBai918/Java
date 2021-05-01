package view;

import java.util.Date;
import java.util.List;

import data.DataBase;
import pojo.ManagerPerson;
import manager.ManagerPersonManager;
import tools.Tools;

/**
 * ����Ա�Ľ�������
 */
public class ManagerPersonView {

	/**
	 * ����Ա��¼
*/
	public static boolean login() {
		System.out.println("���������Ա���˻���");
		String username = Tools.scanner.next();
		System.out.println("���������Ա�����룺");
		String password = Tools.scanner.next();
		// �ж��Ƿ��¼�ɹ�������ɹ�����¼����Ա����Ϣ��ŵ�request login��
		if (ManagerPersonManager.login(username, password)) {
			if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
				System.out.println("��ӭ��������Ա");
			} else {
				System.out.println("��ӭ����Ա");
			}
			return true;
		} else {
			System.out.println("��¼ʧ��");
			return false;
		}
	}

	/**
	 * ����һ������Ա
	 */
	public static void add() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
			// �½�һ��ѧ���Ķ���
			ManagerPerson managerPerson = new ManagerPerson();
			// ��Ӵ�������Ա��ʱ��
			managerPerson.setCreateDate(new Date());
			managerPerson.setRank(1);
			System.out.println("���������Ա���˻���");
			managerPerson.setUsername(Tools.scanner.next());
			System.out.println("���������Ա�����룺");
			managerPerson.setPassword(Tools.scanner.next());
			System.out.println("���������Ա��������");
			managerPerson.setName(Tools.scanner.next());
			System.out.println("��ѡ�����Ա���Ա�");
			System.out.println("0��Ů��  1���У�  2������");

			// �������Ա���Ա𣬲��������ݵ�У��
			int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
			managerPerson.setSex(sex > 2 ? 2 : sex);

			System.out.println("���������Ա���䣺");
			managerPerson.setAge(Tools.getInteger(Tools.scanner.next(), 0));
			managerPerson.setCreateDate(new Date());// ��ӹ���Ա��ʱ��
			System.out.println("���������Ա�ĵ�ַ��");
			managerPerson.setAddress(Tools.scanner.next());

			if(ManagerPersonManager.add(managerPerson)){
				System.out.println("��ӳɹ�");
			}
			else{
				System.out.println("���ʧ�ܣ��û������Ѿ�����");
			}
			
		}
		else{
			System.out.println("����Ȩ�޲���");
		}
	}

	/**
	 * ɾ��һ������Ա
	 */
	public static void del() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
			System.out.println("���������Ա���˻���");
			String username = Tools.scanner.next();
			ManagerPerson managerPerson = ManagerPersonManager.findByUserName(username);
			if (managerPerson == null) {
				System.out.println("ɾ���Ĺ���Ա������");
			} else {
				if(managerPerson.getRank()==1){
					ManagerPersonManager.del(username);
					System.out.println("ɾ���ɹ�");
				}
				else{
					System.out.println("ɾ��ʧ�ܣ�����Ȩ�޲���");
				}
				
			}
		} else {
			System.out.println("����Ȩ�޲���");
		}
	}

	/**
	 * ����һ������Ա
	 */
	public static void findByUsername() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
			System.out.println("���������Ա�ı�ţ�");
			String username = Tools.scanner.next();
			ManagerPerson managerPerson = ManagerPersonManager.findByUserName(username);
			if (managerPerson == null) {
				System.out.println("������ı���Ҳ���");
			} else {
				System.out.println(managerPerson);
			}
		} else {
			System.out.println("����Ȩ�޲���");
		}
	}

	/**
	 * �������еĹ���Ա
	 */
	public static void find() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {

			List<ManagerPerson> list = ManagerPersonManager.find();
			for (ManagerPerson managerPerson : list) {
				System.out.println(managerPerson);
			}
		} else {
			System.out.println("����Ȩ�޲���");
		}
	}

	/**
	 * �޸ı��˵���Ϣ
	 */
	public static void updateMy() {

		ManagerPerson managerPerson = ((ManagerPerson) DataBase.getRequest().get("login"));
		if (managerPerson == null) {
			System.out.println("Ҫ�޸ĵĹ���Ա������");
		} else {
			System.out.println("����Ա�������ǣ�" + managerPerson.getName());
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("���������Ա��������");
				managerPerson.setName(Tools.scanner.next());
			}

			System.out.println("����Ա�������ǣ�*****");
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("���������Ա�����룺");
				managerPerson.setPassword(Tools.scanner.next());
			}

			System.out.println("����Ա���Ա��ǣ�" + Tools.getSex(managerPerson.getSex()));
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("��ѡ�����Ա���Ա�");
				System.out.println("0��Ů��  1���У�  2������");

				// �������Ա���Ա𣬲��������ݵ�У��
				int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
				managerPerson.setSex(sex > 2 ? 2 : sex);
			}

			System.out.println("����Ա�������ǣ�" + managerPerson.getAge());
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("���������Ա�����䣺");
				managerPerson.setAge(Tools.getInteger(Tools.scanner.next(), 0));
			}

			System.out.println("����Ա�ĵ�ַ�ǣ�" + managerPerson.getAddress());
			System.out.println("�޸���ѡ��1�����޸���ѡ��2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("���������Ա�ĵ�ַ��");
				managerPerson.setAddress(Tools.scanner.next());
			}
			
			System.out.println("�޸ĳɹ�");
		}
	}

	/**
	 * �޸Ĺ���Ա����Ϣ
	 */
	public static void update() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {

			System.out.println("���������Ա���˻���");
			String username = Tools.scanner.next();
			ManagerPerson managerPerson = ManagerPersonManager.findByUserName(username);
			if (managerPerson == null) {
				System.out.println("Ҫ�޸ĵĹ���Ա������");
			} else {
				System.out.println("����Ա�������ǣ�" + managerPerson.getName());
				System.out.println("�޸���ѡ��1�����޸���ѡ��2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("���������Ա��������");
					managerPerson.setName(Tools.scanner.next());
				}

				System.out.println("����Ա�������ǣ�*****");
				System.out.println("�޸���ѡ��1�����޸���ѡ��2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("���������Ա�����룺");
					managerPerson.setPassword(Tools.scanner.next());
				}

				System.out.println("����Ա���Ա��ǣ�" + Tools.getSex(managerPerson.getSex()));
				System.out.println("�޸���ѡ��1�����޸���ѡ��2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("��ѡ�����Ա���Ա�");
					System.out.println("0��Ů��  1���У�  2������");

					// �������Ա���Ա𣬲��������ݵ�У��
					int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
					managerPerson.setSex(sex > 2 ? 2 : sex);
				}

				System.out.println("����Ա�������ǣ�" + managerPerson.getAge());
				System.out.println("�޸���ѡ��1�����޸���ѡ��2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("���������Ա�����䣺");
					managerPerson.setAge(Tools.getInteger(Tools.scanner.next(), 0));
				}

				System.out.println("����Ա�ĵ�ַ�ǣ�" + managerPerson.getAddress());
				System.out.println("�޸���ѡ��1�����޸���ѡ��2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("���������Ա�ĵ�ַ��");
					managerPerson.setAddress(Tools.scanner.next());
				}
				System.out.println("�޸ĳɹ�");
			}
		} else {
			System.out.println("����Ȩ�޲���");
		}
	}
}


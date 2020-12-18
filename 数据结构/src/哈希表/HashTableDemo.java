package ��ϣ��;

import java.util.Scanner;
 
//��ϣ��(���ʾ�������)�Ľṹ��������+�����������+��������ɣ�ʵ�ֵ�˼·�Ǵ���һ���̶���С���������飬
//���������������������й��������Զ���Ĺ��򣬽��������β��������У���������������ǳ����㡣
//https://blog.csdn.net/weixin_44279178/article/details/108469778
public class HashTableDemo {
	public static void main(String[] args) {
		// ����Hashtab
		HashTable ht = new HashTable(7);
		String key = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("��ӹ�Ա��add");
			System.out.println("������Ա��list");
			System.out.println("���ҹ�Ա��get");
			System.out.println("ɾ����Ա��del");
			System.out.println("�˳���exit");
			key = sc.next();
			switch (key) {
			case "add":
				System.out.println("����id");
				int id = sc.nextInt();
				System.out.println("��������");
				String name = sc.next();
				Emp emp = new Emp(id, name);
				ht.add(emp);
				break;
			case "list":
				ht.list();
				break;
			case "exit":
				System.out.println("�˳�ϵͳ��");
				sc.close();
				System.exit(0);
			case "get":
				System.out.println("������id");
				int no = sc.nextInt();
				ht.findById(no);
				break;
			case "del":
				System.out.println("������Ҫɾ��Ա����Id");
				int eid = sc.nextInt();
				ht.del(eid);
				break;
			default:
				System.out.println("�������!");
				break;
			}
		}
	}
}
 
//����hash�������������
class HashTable {
	private EmpLinkedList[] arr;
	private int size;
 
	// ��ʼ��������
	public HashTable(int size) {
		// ������СΪ7������
		arr = new EmpLinkedList[size];
		this.size = size;
		// ���˳�ʼ�����飬����Ҫ��ʼ������
		for (int i = 0; i < size; i++) {
			arr[i] = new EmpLinkedList();
		}
	}
 
	// ���Ա��
	public void add(Emp emp) {
		// ����ɢ�к���ȷ��Ա�����Ӧ�÷���������������
		int hashFun = hashFun(emp.id);
		arr[hashFun].add(emp);
	}
 
	// �Զ���ɢ�к���
	public int hashFun(int id) {
		return id % size;
	}
 
	// ������ϣ��
	public void list() {
		for (int i = 0; i < size; i++) {
			arr[i].list(i);
		}
	}
	//����idɾ��Ա��
	public void del(int no) {
		int id = hashFun(no);
		arr[id].del(no);
	}
 
	// ����Id���ҹ�Ա
	public void findById(int id) {
		int hashFun = hashFun(id);
		Emp emp = arr[hashFun].findById(id);
		if (emp == null) {
			System.out.println("û�и�Ա����");
		} else {
			System.out.printf("Ա��id��%d,������%s", emp.id, emp.name);
		}
	}
}
 
//����һ����Ա
class Emp {
	public int id;
	public String name;
	public Emp next;
 
	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
 
}
 
//����һ�������࣬��װ��ɾ�Ĳ鷽��
class EmpLinkedList {
	// ����һ��ͷ��㣬ֱ��ָ���һ��Emp
	private Emp head;// Ĭ��Ϊnull
 
	// ���ݹ�ԱID����
	public Emp findById(int id) {
		// ��ͷ���Ϊ��ʱ��˵������Ϊ�գ�
		if (head == null) {
			return null;
		}
		Emp temp = head;
		while (true) {
			// �ҵ�ID
			if (temp.id == id) {
				break;
			}
			// ����������û���ҵ�
			if (temp.next == null) {
				temp = null;
				break;
			}
			temp = temp.next;
		}
		return temp;
	}
 
	/*
	 * ��ӹ�Ա
	 */
	public void add(Emp emp) {
		
		// �������ӵ��ǵ�һ����Ա����ͷ���ֱ��ָ��ǰ��ӵĽڵ�
		if (head == null) {
			head = emp;
			return;
		}
 
		Emp temp = head;// ���帨���ڵ�
		// ���ǵ�һ���ڵ㣬��������������ӵĽڵ�������һ���ڵ�ĺ���
		// ѭ�������ҵ����һ���ڵ�
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// ����ӵĽڵ�����ҵ������ڵ�ĺ���
		temp.next = emp;
	}
 
	// �����ڵ�
	public void list(int no) {
		if (head == null) {
			System.out.println("��" + (no + 1) + "����Ϊ�գ�");
			return;
		}
		Emp temp = head;// ���帨���ڵ㣬���ڱ���
		while (true) {
			System.out.printf("��" + (no + 1) + "�����id��%d,������%s\t", temp.id, temp.name);
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		System.out.println();
	}
 
	// ɾ����Ա
	public void del(int no) {
		if(head == null) {
			System.out.println("������Ϊ�գ�");
			return;
		}
		// ��ͷ����id����Ҫ���ҵ�id��ֱ��ɾ��
		if (head.id == no) {
			head = head.next;
			return;
		}
		Emp temp = head;// ���帨���ڵ�
		boolean flag = false;
		while (true) {
 
			if (temp.next == null) {
				break;// ˵��û���ҵ��õ�
			}
			if (temp.next.id == no) {
				// ɾ������
				flag = true;
				break;
			}
		}
		if (flag) {
			// �ҵ���id��ɾ��
			temp.next = temp.next.next;
		} else {
			System.out.println("û���ҵ���Ա����");
		}
	}
}
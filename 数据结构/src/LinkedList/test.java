package LinkedList;
//��֤��
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub�Զ����ɵķ������
		
		Student stu1=new Student(1,"��һ");//��������
		Student stu2=new Student(1,"�Ŷ�");
		Student stu3=new Student(1,"����");
		StuNode sn1=new StuNode(stu1);//��Ϊ�����ڵ�
		StuNode sn2=new StuNode(stu2);
		StuNode sn3=new StuNode(stu3);
		StuNode sn0=new StuNode(null);
		StuLinkList sl=new StuLinkList(sn0);//ͷΪ��
//		������
		sl.addAtHead(sn1);
		sl.addAtHead(sn2);
		sl.addAtHead(sn3);
		sl.showDatas();
		
	}

}

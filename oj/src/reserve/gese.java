package reserve;

//private��get����set��������
//Alt+Shift+s   ��r=��ȡget��set����

public class gese {
	
private String name;

//	���캯���������Գ�ʼ��
	public gese() {
		this.name="xiaozhu";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend xiaofang=new Friend();
		xiaofang.age=18;
		System.out.print(xiaofang.age);
//		xiaofang.name=zhuzhu;
//		System.out.print(xiaofang.name);
//		ͨ��set��������name����ֵ
		xiaofang.setName("zhuzhu");
//		ͨ��get������ȡname����ֵ
		String name=xiaofang.getName();
		
		System.out.print(name);

		
	}
}

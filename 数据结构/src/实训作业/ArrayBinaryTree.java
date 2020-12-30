package ʵѵ��ҵ;

//�����������Ҫ���Һ��ӣ�͵��д��
public class ArrayBinaryTree<T>{
	T[] datas;

	public ArrayBinaryTree(T[] datas) {
		super();
		this.datas = datas;
	}
	
	//ǰ�����  ������ indexΪ��ǰ���ĸ����
	public void preOrder(int index){
		if(datas==null || datas.length==0){
			System.out.println("�������������~~");
		}
		System.out.println(datas[index]);		//�����
		if(2*index+1<datas.length){
			preOrder(2*index+1);					//����������
		}
		if(2*index+2<datas.length){
			preOrder(2*index+2);					//����������
		}
	}
	
	//������� �����
	public void infixOrder(int index){
		if(datas==null || datas.length==0){
			System.out.println("�������������~~");
		}
		if(2*index+1<datas.length){
			infixOrder(2*index+1);					//����������
		}
		System.out.println(datas[index]);		//�����
		if(2*index+2<datas.length){
			infixOrder(2*index+2);					//����������
		}
	}
	
	//������� ���Ҹ�
	public void postOrder(int index){
		if(datas==null || datas.length==0){
			System.out.println("�������������~~");
		}
		if(2*index+1<datas.length){
			postOrder(2*index+1);					//����������
		}
		if(2*index+2<datas.length){
			postOrder(2*index+2);					//����������
		}
		System.out.println(datas[index]);		//�����
	}
	

}

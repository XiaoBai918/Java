package ʵѵ��ҵ;

//ѹ��ϡ����󣬱���ԭʼ������У��У�����Ԫ������������Ԫ�ķֲ�
public class CompressSparseMatrix {
	int rows;	//ԭʼ���������
	int cols;	//ԭʼ���������
	int terms;	//ԭʼ�����з���Ԫ����
	Node[] datas;	//����Ԫ���飬��Ԫ���
	public CompressSparseMatrix(int terms) {
		super();
		this.terms = terms;
		datas= new Node[terms];
	}
}
//�洢ÿ������Ԫ�ķֲ���Ϣ���У��У�ֵ 
class Node{
	private int i;		//�洢����Ԫ���к�
	private int j;		//�洢����Ԫ���к�
	private int v;		//�洢����Ԫ��ֵ
	public Node(int i, int j, int v) {
		super();
		this.i = i;
		this.j = j;
		this.v = v;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	
}


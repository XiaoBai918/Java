package linerList;

public class StuSeqList {
//���ݼ��ϴ洢��������������.��������Ϊ��������
	//�κ�һ������û�г�ʼ����û����
private Student[] students;
private int maxlength;//��󳤶�
private int length;//��ǰ����

public StuSeqList(int maxlength,int length) {
    this.length=length;
    this.maxlength=maxlength;
    initate(maxlength);
}
private void initate(int maxlength)
{
  students =new Student[maxlength];
}
public int length()
{
  return length;
}
public int maxlength()
{
  return maxlength;
}

public boolean insert(int index,Student student)
{
	boolean suc=false;
	if(index<0||index>length)
	{
		System.out.print("����λ���д�");
		return suc;
	}
	if(length+1 >maxlength)
	{
		System.out.print("���Ա�����");
		return suc;	
	}
	length++;
	for(;index<length;index++)
	{
		Student temp =students[index];
		students[index]=student;
		student=temp;
		suc=true;
		
		}
	return suc;
	
}

}

package ������������;

class ThNode			//�����������������
{  char data;			//��Ž��ֵ
   ThNode lchild,rchild;		//���Һ��ӻ�������ָ��
   int ltag,rtag;		//���ұ�־
   public ThNode()		//Ĭ�Ϲ��췽��
   {  lchild=rchild=null;
      ltag=rtag=0;
   }
   public ThNode(char d)		//���ع��췽��
   {  data=d;
      lchild=rchild=null;
      ltag=rtag=0;
   }
}

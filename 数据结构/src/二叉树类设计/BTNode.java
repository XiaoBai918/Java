package �����������;

//��ӦJava���ԵĶ����������BTNode<E>
class BTNode<E>			//�������н����
{  E data;			//�������Ԫ��
   BTNode lchild;		//ָ�����ӽ��
   BTNode rchild;		//ָ���Һ��ӽ��
   public BTNode()		//Ĭ�Ϲ��췽��
   {  lchild=rchild=null;  }
   public BTNode(E d)		//���ع��췽��
   {  data=d;
      lchild=rchild=null;
   }
}


package ������������;

public class ThreadClass
{  ThNode b;		//�������ĸ����
   ThNode root;		//������������ͷ���
   ThNode pre;		//��������������,ָ������ǰ�����
   String bstr;
   public ThreadClass()
   {
      root=null;
   }
   //���������������Ļ�������
public void CreateThread()	//������rootΪͷ������������������
{  root=new ThNode();		//����ͷ���root
   root.ltag=0; root.rtag=1;	//ͷ������ó�ֵ
   if (b==null)			//bΪ����ʱ
   {  root.lchild=root;
      root.rchild=null;
   }
   else				//b��Ϊ����ʱ
   {  root.lchild=b;
      pre=root;			//pre��p��ǰ�����,����������
      Thread(b);			//�������������������
      pre.rchild=root;		//�����,����ָ�����������
      pre.rtag=1;
      root.rchild=pre;		//�������������
   }
}

private void Thread(ThNode p)	//����pΪ�����Ķ�������������������
{  if (p!=null)
   {
      Thread(p.lchild);		//������������
      if (p.lchild==null)	//ǰ������
      {  p.lchild=pre;		//�����p���ǰ������
         p.ltag=1;
      }
      else p.ltag=0;
      if (pre.rchild==null)
      {  pre.rchild=p;		//�����pre��Ӻ������
         pre.rtag=1;
      }
      else pre.rtag=0;
      pre=p;			//��p���Ϊ��һ�η��ʽ���ǰ�����
      Thread(p.rchild);		//������������
   }
}
}

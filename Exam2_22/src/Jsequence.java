class Joseph			//���Լɪ��������
	{  int n,m;
	   Child first;			//�׽��ָ��
	   public Joseph(int n1,int m1) 	//���췽��,������n1������ѭ��������
	   {  Child p,t;			//tָ���½�ѭ���������β���
	      n=n1; m=m1;		//�����ݳ�Աֵ
	      first=new Child(1);	//�Ƚ���noΪ1���׽��
	      t=first;
	      for (int i=2;i<=n;i++)
	      {  p=new Child(i);		//����һ�����Ϊi���½��p
	         t.next=p; t=p;		//��p�������ĩβ
	      }
	      t.next=first;		//����һ���׽��Ϊfirst��ѭ��������
	   }

public String Jsequence()	//���Լɪ������
   {  String ans="";
      int i,j;
      Child p,q;
      for (i=1;i<=n;i++)		//������n��С��
      {  p=first;
         j=1;
         while (j<m-1)		//��first��㿪ʼ������������m-1�����
         {  j++;			//��������
            p=p.next;		//�Ƶ���һ�����
         }
         q=p.next;		//qָ���m�����
         ans+=q.no+" ";		//�ý���С������
         p.next=q.next;		//ɾ��q���
         first=p.next;		//����һ��������¿�ʼ
      }
      return ans;
   }
}
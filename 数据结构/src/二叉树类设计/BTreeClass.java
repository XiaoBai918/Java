package �����������;

import java.util.Stack;

public class BTreeClass		//��������
{  BTNode<Character> b;		//�����
   String bstr;			//�����������ű�ʾ��
   public BTreeClass()		//���췽��
   {   b=null;  }
   //���������������㷨

   
//   �����ű�ʾ��str������bΪ�����Ķ������洢�ṹ
public void CreateBTree(String str)
{  Stack<BTNode> st=new Stack<BTNode>();	 //����һ��ջst
   BTNode<Character> p=null;
   boolean flag=true;
   char ch;
   int i=0;
   while (i<str.length())	//ѭ��ɨ��str��ÿ���ַ�
   {  ch=str.charAt(i);
      switch(ch)
      {
	case '(':
	   st.push(p);		//�ո��½��Ľ���к���,�����ջ
           flag=true;
           break;
	case ')':
           st.pop();		//ջ���������������꣬��ջ
           break;
	case ',':
           flag=false;		//��ʼ����ջ�������Һ���
           break;
    default:
        p=new BTNode<Character>(ch);	//��chֵ�½�һ�����
        if (b==null) b=p;		//����δ���������,p��Ϊ�����
        else				//�ѽ��������������
        {  if (flag)			//�½��p��Ϊջ����������
           {  if (!st.empty())
                 st.peek().lchild=p;
           }
           else			//�½��p��Ϊջ�������Һ���
           {  if (!st.empty())
                 st.peek().rchild=p;
           }
        }
        break;
     }
     i++;				//��������
 }
}
}

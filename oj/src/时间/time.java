package ʱ��;

import java.text.SimpleDateFormat;
//SimpleDateFormat ��һ�������Ի������еķ�ʽ����ʽ���ͷ������ڵ��࣬������ѡ���κ��û��Զ�������ʱ���ʽ�����С�
import java.util.Date;

public class time {
   public static void main(String args[]) {
	   
       // ��ʼ�� Date ����
       Date date = new Date();
       // ʹ�� toString() ������ʾ����ʱ��
       System.out.println(date.toString());
      
       
       Date Now = new Date( );
       SimpleDateFormat t = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//ȷ����ת���ĸ�ʽ������ yyyy �������Ĺ�Ԫ�꣬MM ���·ݣ�dd �����ڣ�HH:mm:ss ��ʱ���֡��롣
//ע��:�еĸ�ʽ��д���еĸ�ʽСд������ MM ���·ݣ�mm �Ƿ֣�HH �� 24 Сʱ�ƣ��� hh �� 12 Сʱ�ơ�
       System.out.println("��ǰʱ��Ϊ: " + t.format(Now));
       
       System.out.println(t.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
   }
}
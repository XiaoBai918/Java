package reserve;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class DateTraveller {
public static void main(String[] args) throws ParseException {
 //ͨ��������ַ�������ת��Ϊ��Ӧ��������
 int days;
 int day;
 System.out.println("����������(��ʽ��2020-9-10):");
 @SuppressWarnings("resource")
Scanner scanner=new Scanner(System.in);
 String str=scanner.nextLine();//�����ѯ����
 DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
 Date d=df.parse(str);  //���ַ���ת��Ϊʱ�����
 Calendar c=new GregorianCalendar();
 c.setTime(d);//��ʱ�����ת��λ���ڶ���
 day=c.get(Calendar.DAY_OF_MONTH);//���������ض���������
 System.out.println("��\tһ\t��\t��\t��\t��\t��\t");
 c.set(Calendar.DAY_OF_MONTH, 1); //���õ�һ��
 for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++) {
  System.out.print("\t");//�·ݵĵ�һ�Ŷ�Ӧ������ǰ�����\t����
 }
 days=c.getActualMaximum(Calendar.DATE);//������ѯ�����·�������
 for(int i=1;i<=days;i++) {//���������ڵĵ��µ����ֵ
 if(c.get(Calendar.DAY_OF_MONTH)==day) {
   System.out.print("["+c.get(Calendar.DAY_OF_MONTH)+"]\t");//�ض���������ʽ��[]��ʶ����
  }else {
   System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
  }
  if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) { //ÿ�������ͻ���
   
   System.out.println();//����
   
  }
  c.add(Calendar.DAY_OF_MONTH, 1);//������һ
   
 }
}
}

package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Tools {
	// ʱ���ʽ��
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// ����һ������
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * ʱ��ĸ�ʽ��
	 * @param string
	 * @return
	 */
	public static Date getDate(String string){
		try {
			return format.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	
	/**
	 * ���ַ���תΪ�����������������ַ����������������򷵻ز����е�int��
	 * 
	 * @param numStr
	 *            Ҫת�����ַ���
	 * @param deInt
	 *            Ĭ�ϵ�������
	 * @return ����ת���Ľ��
	 */
	public static int getInteger(String numStr, int deInt) {
		int num=0;
		try {
			num=Integer.parseInt(numStr);
		} catch (Exception e) {
			num=deInt;
		}
		return num;
	}

	/**
	 * �����û����Ա���룬����û����Ա��ַ�
	 * 
	 * @param sex
	 *            �û����Ա�ı���
	 * @return �û����Ա���ַ�
	 */
	public static String getSex(int sex) {
		if (sex == 0) {
			return "Ů";
		} else if (sex == 1) {
			return "��";
		} else {
			return "����";
		}
	}

	/**
	 * ��һ������תΪdouble�������ʽ���󣬾�תΪĬ�ϵ���
	 * 
	 * @param numStr
	 *            Ҫת������
	 * @param num
	 *            Ĭ�ϵ�����
	 * @return ת���Ľ��
	 */
	public static double getDouble(String numStr, double num) {
		double num2 = 0;
		try {
			num2 = Double.parseDouble(numStr);
		} catch (NumberFormatException e) {
			System.out.println("����������ֵĸ�ʽ�����Ѿ���ΪĬ�ϵ���");
			num2 = num;

		}
		return num2;
	}

}


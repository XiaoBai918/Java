package com.runoob.test;

import java.sql.*;       //����java.sql��

public class ���� {
		static Connection con;     //����Connection����
		static Statement sql;      //����Statement����
		static ResultSet res;      //����ResultSet����
		public Connection getConnection(){    //��������ֵΪConnection�ķ���
			try {                             //�������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("���ݿ��������سɹ�");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try {                 //ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql");
				System.out.println("���ݿ����ӳɹ�");
				System.out.print('\n');
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return con;           //������Ҫ��Ż�һ��Connection����
		}	

}

package �ݹ�;

import java.util.ArrayList;
//����5.6�����õݹ��㷨����Թ����⣬���������ڵ����ڵ������Թ�·���� 
public class Exam5_5
{  public static void main(String[] args)
   {  int [][] a= { {1,1,1,1,1,1},{1,0,1,0,0,1},
	  	   {1,0,0,0,1,1},{1,0,1,0,0,1},
		   {1,0,0,0,0,1},{1,1,1,1,1,1} };
   
   for(int i=0;i<a.length;i++) {//a.length��ʾ����
		System.out.print("{");
		for(int j=0;j<a[i].length;j++) {//a[i].length��ʾ����
			System.out.print(a[i][j]+" ");
		}
		System.out.print("}");
		System.out.println();
	}
   
      MazeClass mz=new MazeClass(6,6);
      ArrayList<Box> path=new ArrayList<Box>();
      mz.Setmg(a);
      mz.mgpath(1,1,4,4,path);
   }
}

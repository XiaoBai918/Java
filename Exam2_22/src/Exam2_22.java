import java.io.FileNotFoundException;

public class Exam2_22
{  public static void main(String[] args) throws FileNotFoundException
   {  System.out.println("********����1***********");
      int n=6,m=3;
      Joseph L=new Joseph(n,m);
      System.out.println("n="+n+",m="+m+"��Լɪ������");
      System.out.println(L.Jsequence());
      System.out.println("********����2***********");
      n=8; m=4;
      L=new Joseph(n,m);
      System.out.println("n="+n+",m="+m+"��Լɪ������");
      System.out.println(L.Jsequence());
      
      System.out.println("********����3***********");
      n=50; m=6;
      L=new Joseph(n,m);
      System.out.println("n="+n+",m="+m+"��Լɪ������");
      System.out.println(L.Jsequence());
   }	
}

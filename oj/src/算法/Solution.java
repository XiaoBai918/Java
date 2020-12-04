package �㷨;

import java.util.Arrays;
import java.util.*;

/**
 * ���ڴ�ע����� �������༶��רҵ
 * ���磺 ������  B190109 �������
 */
public class Solution {
    public static void main(String[] args) {
        //���ڴ˲�����д�ķ���
        //���Ե�һ��
        //test1();

        //���Եڶ���
        //test2();

        //���Ե�����
        //test3();

        //���Ե�����
        test4();
    }

    /**
     * ��һ�⣺һά����Ķ�̬��
     */
    public static int[] runningSum(int[] nums) {
        //���ڴ˲������
        //��ɾ������һ�д���
    	int i,j,temp=0;
        int[] rtnums=new int[nums.length];
        for(i=0;i<nums.length;i++){
            for(j=0;j<=i;j++){
                temp=temp+nums[j];
            }
            rtnums[i]=temp;
            temp=0;
        }
        return rtnums;
    }

    /**
     * �ڶ��⣺����ת�ַ���
     */
    public static String reverseLeftWords(String s, int n) {
        //���ڴ˲������
        //��ɾ������һ�д���
    	 if (s == null || n < 0 || n > s.length()) return "";
         char[] chars = s.toCharArray();
         int length = chars.length;
         
         String reverse = "";
         for(int i =n;i<length;i++){
             reverse += chars[i];
         }
         
         String reverse2 = "";
         for(int k=0;k<n;k++){
             reverse2 +=chars[k];
         }
         
        String reverse3 = reverse + reverse2;
        return reverse3;
     }
    // C����
    	//char* reverseLeftWords(char* s, int n){
//  	int i = 0;
//  	int sz = strlen(s);
//  	for (i = 0; i < sz / 2; i++){
//  		char ret = *(s + i);
//  		*(s + i) = *(s + sz - 1 - i);
//  		*(s + sz - 1 - i) = ret;
//  	}
//  	for (i = 0; i < (sz - n) / 2; i++){
//  		char ret = *(s + i);
//  		*(s + i) = *(s + sz - 1 - n - i);
//  		*(s + sz - 1 - n - i) = ret;
//  	}
//  	for (i = 0; i < n / 2; i++){
//  		char ret = *(s + sz - n + i);
//  		*(s + sz - n + i) = *(s + sz - 1 - i);
//  		*(s + sz - 1 - i) = ret;
//  	}
//  	return s;
//  }    
//  int main(){
//  	char s[] = "lrloseumgh";
//  	int n = 0;
//  	scanf("%d", &n);
//  	reverseLeftWords(s,n);
//  	printf("%s\n", s);
//  	return 0;
//  }
    	

    /**
     * �����⣺�����ظ�3�ε�Ԫ��
     */
    public static boolean containsDuplicate(int[] nums) {
        //���ڴ˲������
        //��ɾ������һ�д���
    	  Arrays.sort(nums);
          int len = nums.length;
          for(int i=0;i<len-1;i++){
              for(int j=i+1;j<len;j++){
                  if(nums[i]==nums[j]) {
                  for(int k=j+1;k<len+1;k++) {
                	  if(nums[j]==nums[k])return true;
                	  else return false;
                  }
                  }
                  else return false;
          }
		return false;
              }
		return false;
    }

    /**
     * �����⣺��ת�ַ���
     */
    public static char[] reverseString(char[] s) {
        //���ڴ˲������
        //��ɾ������һ�д���
    	
    	//˫ָ��
        int begin =0;
        int end =s.length-1;
        while(begin<end){
           //��λ��ĩβ����λ��
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
         }
         return s;
    }
    
//    https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=188&&tqId=36565&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking



    //���µĴ���Ϊ���Դ��룬�����Ķ������Ժ���
    //���µĴ���Ϊ���Դ��룬�����Ķ������Ժ���
    //���µĴ���Ϊ���Դ��룬�����Ķ������Ժ���
    public static void test1() {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        System.out.println("��ĵ�һ�������Ϊ��[1, 2, 3, 4]");
        System.out.print("��ĵ�һ�����Ϊ��");
        printIntElements(result);
    }

    public static void test2() {
        //�ڶ���
        String s = "abcdefg";
        int k = 2;
        System.out.println("��ĵڶ�������Ϊ:s = \"abcdefg\", k = 2");
        System.out.println("��ĵڶ������Ϊ��" + reverseLeftWords(s, k));
    }

    public static void test3() {
        int[] array1 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] array2 = {1, 2, 3, 1};
        System.out.println("��ĵ���������1Ϊ��[1, 1, 1, 3, 3, 4, 3, 2, 4, 2]");
        System.out.println("��ĵ��������1Ϊ��" + containsDuplicate(array1));
        System.out.println("��ĵ���������2Ϊ��[1, 2, 3, 1]");
        System.out.println("��ĵ��������2Ϊ��" + containsDuplicate(array2));
    }

    public static void test4() {
        char[] charArray = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("��ĵ���������Ϊ��");
        printElements(charArray);
        char[] reverseResult = reverseString(charArray);
        System.out.println("��ĵ��������Ϊ��");
        printElements(reverseResult);
    }

	public static void printElements(char[] charArray) {
        System.out.print("[");
        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                System.out.print(charArray[i]);
            } else {
                System.out.print(charArray[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void printIntElements(int[] charArray) {
        System.out.print("[");
        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                System.out.print(charArray[i]);
            } else {
                System.out.print(charArray[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}


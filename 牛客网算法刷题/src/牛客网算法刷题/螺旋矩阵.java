package ţ�����㷨ˢ��;
import java.util.*;
//����һ��m x n��С�ľ���m�У�n�У�����������˳�򷵻ؾ����е�����Ԫ�ء�
//����
//[[1,2,3],[4,5,6],[7,8,9]]
//����ֵ
//[1,2,3,6,9,8,7,4,5]
//1 2 3    ���� 1 2 3 6 9 8 7 4 5
//4 5 6
//7 8 9 
public class �������� {
	
public static ArrayList<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> res = new ArrayList<>();
    if(matrix.length == 0)
        return res;
    int top = 0, bottom = matrix.length-1;
    int left = 0, right = matrix[0].length-1;

    while( top < (matrix.length+1)/2 && left < (matrix[0].length+1)/2 ){
        //����  ����
        for(int i = left; i <= right; i++){
            res.add(matrix[top][i]);
        }

        //�ұ� �ϵ���
        for(int i = top+1; i <= bottom; i++){
            res.add(matrix[i][right]);
        }

        //����  �ҵ���
        for(int i = right-1; top!=bottom && i>=left; i--){
            res.add(matrix[bottom][i]);
        }

        //��� �µ���
        for(int i = bottom-1; left!=right && i>=top+1; i--){
            res.add(matrix[i][left]);
        }
        ++top;
        --bottom;
        ++left;
        --right;
    }
    return res;
    
    
}

public static void main(String[] args) {
    //���ڴ˲�����д�ķ���
    //����
    test();
}
private static void test() {
	// TODO Auto-generated method stub
	 int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9},{1, 2, 3}};
	 ArrayList<Integer> result = spiralOrder(matrix);
     System.out.println("�������Ϊ��"+Arrays.deepToString(matrix));
     System.out.print("������Ϊ:");
     System.out.println(result);
     
     }

}


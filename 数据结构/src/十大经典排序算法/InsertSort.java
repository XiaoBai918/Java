package ʮ�󾭵������㷨;

//��������
public class InsertSort {
    public static int[] insertSort(int[] arr) {
        if(arr == null || arr.length < 2)
            return arr;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            while(k >= 0 && arr[k] > temp)
                k--;
            //�ڳ�λ�ò��ȥ,Ҫ���λ���� k + 1;
            for(int j = i ; j > k + 1; j--)
                arr[j] = arr[j-1];
            //���ȥ
            arr[k+1] = temp;
        }
        return arr;
    }
}
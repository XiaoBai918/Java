package ʮ�󾭵������㷨;

//ϣ�����򣨲�������ı��֣�
public class ShellSort {
    public static int[] shellSort(int arr[]) {
        if (arr == null || arr.length < 2) return arr;
        int n = arr.length;
        // ��ÿ����Ϊ h�ķ���������򣬸տ�ʼ h = n / 2;
         for (int h = n / 2; h > 0; h /= 2) {
            //�Ը����ֲ�������в�������
             for (int i = h; i < n; i++) {
                // ��arr[i] ���뵽���ڷ������ȷλ����
                insertI(arr, h, i);
            }
     }
     return arr;
    }

    /**
     * ��arr[i]���뵽���ڷ������ȷλ����
     * arr[i]] ���ڵķ���Ϊ ... arr[i-2*h],arr[i-h], arr[i+h] ...
     */
    private static void insertI(int[] arr, int h, int i) {
        int temp = arr[i];
        int k;
        for (k = i - h; k > 0 && temp < arr[k]; k -= h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }
}

package ʮ�󾭵������㷨;

//��������
public class Counting {
    public static int[] countSort(int[] arr) {
        if(arr == null || arr.length < 2) return arr;

        int n = arr.length;
        int max = arr[0];
        // Ѱ����������ֵ
        for (int i = 1; i < n; i++) {
            if(max < arr[i])
                max = arr[i];
        }
        //������СΪmax����ʱ����
        int[] temp = new int[max + 1];
        //ͳ��Ԫ��i���ֵĴ���
        for (int i = 0; i < n; i++) {
            temp[arr[i]]++;
        }
        int k = 0;
        //����ʱ����ͳ�ƺõ����ݻ��ܵ�ԭ����
        for (int i = 0; i <= max; i++) {
            for (int j = temp[i]; j > 0; j--) {
                arr[k++] = i;
            }
        }
        return arr;
    }
}


//public class Counting {
//    public static int[] sort(int[] arr) {
//        if(arr == null || arr.length < 2) return arr;
//
//        int n = arr.length;
//        int min = arr[0];
//        int max = arr[0];
//        // Ѱ����������ֵ����Сֵ
//        for (int i = 1; i < n; i++) {
//            if(max < arr[i])
//                max = arr[i];
//            if(min > arr[i])
//                min = arr[i];
//        }
//        int d = max - min + 1;
//        //������СΪmax����ʱ����
//        int[] temp = new int[d];
//        //ͳ��Ԫ��i���ֵĴ���
//        for (int i = 0; i < n; i++) {
//            temp[arr[i] - min]++;
//        }
//        int k = 0;
//        //����ʱ����ͳ�ƺõ����ݻ��ܵ�ԭ����
//        for (int i = 0; i < d; i++) {
//            for (int j = temp[i]; j > 0; j--) {
//                arr[k++] = i + min;
//            }
//        }
//        return arr;
//    }
//}
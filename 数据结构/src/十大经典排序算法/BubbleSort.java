package ʮ�󾭵������㷨;
//ð������
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        return arr;
    }
}

//�Ż�
//public class BubbleSort {
//    public static int[] bubbleSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return arr;
//        }
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < n -i - 1; j++) {
//                if (arr[j + 1] < arr[j]) {
//                    flag = false;
//                    int t = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = t;
//                }
//            }
//            //һ�������Ƿ���λ�ý���
//            if(flag)
//                break;
//        }
//        return arr;
//    }
//}

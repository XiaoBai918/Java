package ʮ�󾭵������㷨;

//public class MergeSort {
//    // �鲢����
//    public static int[] mergeSort(int[] arr, int left, int right) {
//        // ��� left == right����ʾ����ֻ��һ��Ԫ�أ����õݹ�����
//        if (left < right) {
//            // �Ѵ������ָ�����������
//            int mid = (left + right) / 2;
//            // ����벿�ֽ�������
//            arr = mergeSort(arr, left, mid);
//            // ���Ұ벿�ֽ�������
//            arr = mergeSort(arr, mid + 1, right);
//            //���кϲ�
//            merge(arr, left, mid, right);
//        }
//        return arr;
//    }
//
//    // �ϲ����������������������ϲ�����
//    // arr[left..mif]��ʾһ�����飬arr[mid+1 .. right]��ʾһ������
//    private static void merge(int[] arr, int left, int mid, int right) {
//        //����һ����ʱ��������Ǻϲ���������
//        int[] a = new int[right - left + 1];
//        int i = left;
//        int j = mid + 1;
//        int k = 0;
//        while (i <= mid && j <= right) {
//            if (arr[i] < arr[j]) {
//                a[k++] = arr[i++];
//            } else {
//                a[k++] = arr[j++];
//            }
//        }
//        while(i <= mid) a[k++] = arr[i++];
//        while(j <= right) a[k++] = arr[j++];
//        // ����ʱ���鸴�Ƶ�ԭ����
//        for (i = 0; i < k; i++) {
//            arr[left++] = a[i];
//        }
//    }
//}



public class MergeSort {
    // �ǵݹ�ʽ�Ĺ鲢����
    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        // ������Ĵ�С�ֱ�Ϊ1��2��4��8...
        // �տ�ʼ�ϲ��������С��1��������2������4....
        for (int i = 1; i < n; i += i) {
            //����������л���
            int left = 0;
            int mid = left + i - 1;
            int right = mid + i;
            //���кϲ����������СΪ i ��������������ϲ�
            while (right < n) {
                // �ϲ������͵ݹ�ʽ�ĺϲ�����һ��
                merge(arr, left, mid, right);
                left = right + 1;
                mid = left + i - 1;
                right = mid + i;
            }
            // ����һЩ����©������û�ϲ���ǧ�������
            // ��Ϊ������ÿ��������Ĵ�С���պ�Ϊ i
            if (left < n && mid < n) {
                merge(arr, left, mid, n - 1);
            }
        }
        return arr;
    }

	private static void merge(int[] arr, int left, int mid, int right) {
        //����һ����ʱ��������Ǻϲ���������
        int[] a = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                a[k++] = arr[i++];
            } else {
                a[k++] = arr[j++];
            }
        }
        while(i <= mid) a[k++] = arr[i++];
        while(j <= right) a[k++] = arr[j++];
        // ����ʱ���鸴�Ƶ�ԭ����
        for (i = 0; i < k; i++) {
            arr[left++] = a[i];
        }
}
}

package ʮ�󾭵������㷨;

//��������
public class QuickSort {
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //��ȡ����Ԫ��������λ��
            int mid = partition(arr, left, right);
            //���зָ�
            arr = quickSort(arr, left, mid - 1);
            arr = quickSort(arr, mid + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //ѡȡ����Ԫ��
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            // �����ҵ���һ��С�ڵ��� pivot ��Ԫ��λ��
            while (i <= j && arr[i] <= pivot) i++;
            // �����ҵ���һ�����ڵ��� pivot ��Ԫ��λ��
            while(i <= j && arr[j] >= pivot ) j--;
            if(i >= j)
                break;
            //��������Ԫ�ص�λ�ã�ʹ����ߵ�Ԫ�ز�����pivot,�ұߵĲ�С��pivot
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[j];
        // ʹ����Ԫ�ش��������λ��
        arr[j] = pivot;
        return j;
    }
}

package ʮ�󾭵������㷨;

public class Head {
    // ������
    public static int[] headSort(int[] arr) {
        int n = arr.length;
        //�����󶥶�
        for (int i = (n - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, n - 1);
        }
        //���ж�����
        for (int i = n - 1; i >= 1; i--) {
            // �ѶѶ�Ԫ�������һ��Ԫ�ؽ���
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // �Ѵ��ҵĶѽ��е������ָ��ѵ�����
            downAdjust(arr, 0, i - 1);
        }
        return arr;
    }

        //�³�����
    public static void downAdjust(int[] arr, int parent, int n) {
        //��ʱ����Ҫ�³���Ԫ��
        int temp = arr[parent];
        //��λ���ӽڵ��λ��
        int child = 2 * parent + 1;
        //��ʼ�³�
        while (child <= n) {
            // ����Һ��ӽڵ�����Ӵ���λ���Һ���
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            // ������ӽڵ�С�ڻ���ڸ��ڵ㣬���³�����
            if (arr[child] <= temp ) break;
            // ���ڵ�����³�
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
}

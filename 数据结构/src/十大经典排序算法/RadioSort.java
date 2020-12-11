package ʮ�󾭵������㷨;

import java.util.ArrayList;
import java.util.LinkedList;
//��������
public class RadioSort {
    public static int[] radioSort(int[] arr) {
        if(arr == null || arr.length < 2) return arr;

        int n = arr.length;
        int max = arr[0];
        // �ҳ����ֵ
        for (int i = 1; i < n; i++) {
            if(max < arr[i]) max = arr[i];
        }
        // �������ֵ�Ǽ�λ��
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }
        // ����10��Ͱ
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        //��ʼ��Ͱ
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        // ����ÿһ�˵����򣬴Ӹ�λ����ʼ��
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                // ��ȡÿ�������� i λ������
                int radio = (arr[j] / (int)Math.pow(10,i-1)) % 10;
                //�Ž���Ӧ��Ͱ��
                bucketList.get(radio).add(arr[j]);
            }
            //�ϲ��Ż�ԭ����
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer t : bucketList.get(j)) {
                    arr[k++] = t;
                }
                //ȡ�����ϲ���֮���Ͱ�������
                bucketList.get(j).clear();
            }
        }
        return arr;
    }
}

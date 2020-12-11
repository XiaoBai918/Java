package ʮ�󾭵������㷨;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//Ͱ����
public class BucketSort {
    public static int[] BucketSort(int[] arr) {
        if(arr == null || arr.length < 2) return arr;

        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        // Ѱ����������ֵ����Сֵ
        for (int i = 1; i < n; i++) {
            if(min > arr[i])
                min = arr[i];
            if(max < arr[i])
                max = arr[i];
        }
        //���Ż��汾�ļ�������һ����Ūһ����СΪ min ��ƫ��ֵ
        int d = max - min;
        //���� d / 5 + 1 ��Ͱ���� i Ͱ���  5*i ~ 5*i+5-1��Χ����
        int bucketNum = d / 5 + 1;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(bucketNum);
        //��ʼ��Ͱ
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        //����ԭ���飬��ÿ��Ԫ�ط���Ͱ��
        for (int i = 0; i < n; i++) {
            bucketList.get((arr[i]-min)/d).add(arr[i] - min);
        }
        //��Ͱ�ڵ�Ԫ�ؽ����������������ϵͳ�Դ������򹤾�
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }
        //��ÿ��Ͱ����õ����ݽ��кϲ����ܷŻ�ԭ����
        int k = 0;
        for (int i = 0; i < bucketNum; i++) {
            for (Integer t : bucketList.get(i)) {
                arr[k++] = t + min;
            }
        }
        return arr;
    }
}
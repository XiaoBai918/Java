package ʮ�󾭵������㷨;

import java.util.Arrays;

public class ����text {

//	https://www.cnblogs.com/itsharehome/p/11058010.html Դ����	
	
	public static void main(String[] args) {
        int a[] = {1,89,67,988,7,54,88,2,45,67,89,65,89};
        System.out.printf("����ǰ:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        Heap.heapSort(a, a.length);
        System.out.printf("������:");
        System.out.printf(Arrays.toString(a)+"\n");
        BucketSort.BucketSort(a);
        System.out.printf("Ͱ����:");
        System.out.printf(Arrays.toString(a)+"\n");
        SelectSort.selectSort(a);
        System.out.printf("ѡ������:");
        System.out.printf(Arrays.toString(a)+"\n");
        BubbleSort.bubbleSort(a);
        System.out.printf("ð������:");
        System.out.printf(Arrays.toString(a)+"\n");
        Counting.countSort(a);
        System.out.printf("��������:");
        System.out.printf(Arrays.toString(a)+"\n");
        InsertSort.insertSort(a);
        System.out.printf("��������:");
        System.out.printf(Arrays.toString(a)+"\n");
        MergeSort.mergeSort(a);
        System.out.printf("�鲢����:");
        System.out.printf(Arrays.toString(a)+"\n");
        QuickSort.quickSort(a,1,12);
        System.out.printf("��������:");
        System.out.printf(Arrays.toString(a)+"\n");
        RadioSort.radioSort(a);
        System.out.printf("��������:");
        System.out.printf(Arrays.toString(a)+"\n");
        ShellSort.shellSort(a);
        System.out.printf("ϣ������:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        
        
    }

}

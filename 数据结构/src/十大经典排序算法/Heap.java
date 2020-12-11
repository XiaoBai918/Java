package ʮ�󾭵������㷨;

import java.util.Arrays;

public class Heap {

    public static void swap(int[] num,int start, int end){
        // ��ʼλ�� 
        int s = start;
        //ȡ�����ҽڵ�ϴ�ĵ��λ��
        int lOr = 2*s+1;
        //��¼��ʱֵ ���ں��潻��
        int tmp = num[s];
        
        //�����ֵ�������鳤��������s��Ϊ��¼��һ��ֵ��lOr��Ϊ��һ��ֵ�������������������������εĵ�͸�ֵΪtmp
        for(;lOr <= end; s=lOr, lOr = lOr*2+1){
            if(lOr < end && num[lOr] < num[lOr+1]){
                lOr++;
            }
            if(tmp >= num[lOr]){
                break;
            }else {
                num[s] = num[lOr];
                num[lOr] = tmp;
            }
        }
    }


    public static void heapSort(int[] num, int len){
        int i, tmp;
        //�ȵ����ṹ
        for(i = len/2-1; i >= 0; i--){
            swap(num,i,len-1);
        }
        for(i = len - 1; i > 0; i--){
            tmp = num[0];
            num[0] = num[i];
            num[i] = tmp;
            //�����һ���͵���һ�����Ľṹ
            swap(num,0,i-1);
        }

    }

    public static void main(String[] args) {
        int a[] = {20,2,80,1,16,100,6,78};
        System.out.printf("����ǰ:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        Heap.heapSort(a, a.length);
        System.out.printf("�����:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        
//        System.out.printf("����ǰ:");
//        for (int i=0; i<a.length; i++)
//            System.out.print(a[i]+" ");
//        System.out.printf("\n");
//        heapSort(a, a.length);
//
//        System.out.printf("�����:");
//        for (int i=0; i<a.length; i++)
//            System.out.print(a[i]+" ");
//        System.out.printf("\n");
    }
}


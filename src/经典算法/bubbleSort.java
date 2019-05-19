package 经典算法;

import java.util.Arrays;

public class bubbleSort {
    public static void BubbleSort(int[] arr) {
        boolean flag = true;
        while(flag){
            int temp;//定义一个临时变量
            for(int i=0;i<arr.length-1;i++){//冒泡趟数，n-1趟
                flag = false;
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j+1]<arr[j]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        flag = true;
                    }
                }
                if(!flag){
                    break;//若果没有发生交换，则退出循环
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,6,2,2,5};
        bubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}


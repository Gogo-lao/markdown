package 经典算法;

import java.util.Arrays;

public class quickSort {
    public static void quicksort(int[] data){
        quicksortOptimized(data, 0, data.length-1);
    }

    private static void quicksortOptimized(int[] data, int left, int right){
        int pivot = data[(left+right)/2];
        int i=left;
        int j=right;
        while(i<=j){
            while(data[i] < pivot) i++;
            while(data[j] > pivot) j--;
            if(i<=j){
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;j--;
            }
        }
        if(left < j){
            quicksortOptimized(data, left, j);
        }
        if(i < right){
            quicksortOptimized(data, i, right);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[] {2,3,4,15,7};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

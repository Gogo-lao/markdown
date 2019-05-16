package 经典算法;

import java.util.Arrays;

public class mergeSort {
    private static void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int mid = (start + end) / 2;
        // 递归实现归并排序
        sort(array, start, mid);
        sort(array, mid + 1, end);
        mergerSort(array, start, mid, end);
    }

    // 将两个有序序列归并为一个有序序列(二路归并)
    private static void mergerSort(int[] array, int start, int mid, int end) {
        // TODO Auto-generated method stub
        int[] arr = new int[end + 1]; // 定义一个临时数组，用来存储排序后的结果
        int low = start; // 临时数组的索引
        int left = start;

        int center = mid + 1;
        // 取出最小值放入临时数组中
        while (start <= mid && center <= end) {
            arr[low++] = array[start] > array[center] ? array[center++] : array[start++];
        }

        // 若还有段序列不为空，则将其加入临时数组末尾

        while (start <= mid) {
            arr[low++] = array[start++];
        }
        while (center <= end) {
            arr[low++] = array[center++];
        }

        // 将临时数组中的值copy到原数组中
        for (int i = left; i <= end; i++) {
            array[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] array = { 58, 48, 69, 87, 49, 59, 25, 35, 68, 48 };
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}

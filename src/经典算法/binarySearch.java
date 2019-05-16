package 经典算法;

import java.util.Arrays;

public class binarySearch {
    //非递归实现
    public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

    //递归实现
    public static int sort(int []array,int a,int lo,int hi){
        if(lo<=hi){
            int mid=(lo+hi)/2;
            if(a==array[mid]){
                return mid+1;
            }
            else if(a>array[mid]){
                return sort(array,a,mid+1,hi);
            }else{
                return sort(array,a,lo,mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[] {2,3,4,15,7};
        int result = biSearch(arr,4);
        int result1 = biSearch(arr,4);
        System.out.println(result+"  " + result1);
    }
}

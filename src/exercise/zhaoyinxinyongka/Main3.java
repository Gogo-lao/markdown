package exercise.zhaoyinxinyongka;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i != n ; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int j = 0; j < n-1; j++) {
            if(arr[j] < 0 ){
                sum += arr[j];
            }else{
                sum -= arr[j];
            }
        }
        if(sum < 0)
            sum = arr[n-1] - sum;
        else {
            sum = sum > arr[n-1]?  sum - arr[n - 1]:arr[n-1]-sum;
        }
        System.out.println(sum);
    }
}
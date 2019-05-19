package Gbit;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= arr[i]) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            if (sum < min)
                min = sum;
        }
        System.out.println(min);
    }
}

package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int N = in.nextInt();
       int W = in.nextInt();
       int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int count = 0;
        int index = 0;
        for (int i=0,j=N-1; i<=j;) {
            if(arr[i]+arr[j] <= W){
                i++;
                index++;
            }
            else {
                count += 2;
                i++;j--;
            }
        }
        count += index/2;

        System.out.println(count);

    }
}

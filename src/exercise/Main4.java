package exercise;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0 || n == 1)
            System.out.println(0);
        int arr[]=new int[] {0,1,2};
        if (n<=3) {
            System.out.println(arr[n-1]);
            return;
        }

        int result = 1;
        while (n - 3 > 2){
            result *= 3;
            n -= 3;
        }
        result *= n;
        System.out.println(result);

    }
}
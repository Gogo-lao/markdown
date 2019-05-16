package exercise.zhaoyinxinyongka;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];

        for (int i = 0; i !=n ; i++) {
            height[i] = in.nextInt();
        }
        Arrays.sort(height);
        if((height[n-1]-height[1]) <= k)
            System.out.println(2);

    }
}
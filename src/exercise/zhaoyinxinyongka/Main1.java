package exercise.zhaoyinxinyongka;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] len = new int[n];
        int[] strength = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            strength[i] = in.nextInt();
        }


        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if(len[i] == len[j])
                    count++;
//                else{
//                    int max = len[n-1];
//                    if()
//                }
                if(count >= n/2+1){
                    System.out.println(0);
                    return;
                }

            }
        }



    }
}
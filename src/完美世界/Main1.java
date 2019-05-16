package 完美世界;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int time = in.nextInt();
        int j = 0;
        int maxScore = 0;
        int score = 0;
        while(j+1 < n){
            score = 0;
            int temp = 0;
            for (int i = j; i < n; i++) {
                if(temp + b[i] < time) {
                    temp += b[i];
                    score += a[i];
                }
                continue;
            }
            if (score > maxScore)
                maxScore = score;
        }
        System.out.println(maxScore);

    }
}
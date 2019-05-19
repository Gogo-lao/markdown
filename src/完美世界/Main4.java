package 完美世界;


import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] socer = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            socer[i] = x;
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            time[i] = x;
        }
        int allTime = sc.nextInt();
        System.out.println(maxSoc(n, socer, time, allTime));
    }

    public static int maxSoc(int n, int[] socer, int[] time, int allTime) {//01背包
        int[] dp = new int[allTime + 1];
        for (int i = 0; i < n; i++) {
            for (int j = allTime; j >= 0; j--) {
                if ((j - time[i] >= 0) && (dp[j] <= dp[j - time[i]] + socer[i])) {//状态方程
                    dp[j] = dp[j - time[i]] + socer[i];
                }
            }
        }
        return dp[allTime];
    }
}

package 美团;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int count = findContinueLCS(str1,str2);
        if (count < str2.length())
            System.out.println(0);
        else System.out.println(1);

    }

    public static int findContinueLCS(String a,String b) {
        int len1 = a.length();
        int len2 = b.length();

        int dp[][] = new int[len1+1][len2+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i-1) == b.charAt(j-1) || a.charAt(i-1) == '?') {
                    if (i == 0|| j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                else {
                    dp[i][j] = 0;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }

            }
        }
        return max;
    }

}

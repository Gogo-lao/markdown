package 完美世界;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w[] = new int[n];
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        int time = in.nextInt();

        int [][] temp = new int[n][time];   //8表示背包最多能放8公斤的重量
        for(int j=0;j<time;j++) {  //初始化每一行
            temp[0][j] = 0;
        }
        for(int i=1;i<n;i++) {  //背包的重量为0的时候，最大价值肯定是0
            temp[i][0] = 0;
        }

        for(int i=1;i<n;i++) {  //从第一个物品开始选，记录我选了前面出现的物品，背包重量从1-8的能选上的最大的值
            for(int j=1;j<time;j++) { //当i循环到最后一层5的时候，也就是得到了，我5件物品都选上的时候的最大的值
                if(w[i]<=j) { //重量比这个状态小，那么就能放。 那么就只是放与不放，看是放重量大，还是不放重量大
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-w[i]]+v[i]);
                }else {
                    temp[i][j] = temp[i-1][j];//第i件物品不能放
                }
            }
        }
        System.out.println(temp[n-1][time-1]);


    }
}
package 京东;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int V = in.nextInt();
        int aarr[] = new int[n];
        int barr[] = new int[n];
        for (int i = 0; i < n; i++) {
            aarr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            barr[i] = in.nextInt();
        }
        if (n == 1){
            System.out.printf("%.4f",(double)barr[0]);
            return;
        }

        int peibiSum = 0;
        for (int i = 0; i < n; i++) {
            peibiSum += aarr[i];
        }
        double one = V / peibiSum;
        double[] sum = new double[n];
        double sums = 0;
        for (int i = 0; i < n; i++) {
            sum[i] = one * aarr[i];
            sums += sum[i];
        }


        double res = Math.min(sums,V);

        System.out.printf("%.4f", res);

    }

}

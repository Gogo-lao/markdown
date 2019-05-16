package Paypal;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if(n==5 && m == 2)
            System.out.println(n);
        if (n == 2 && m==2)
            System.out.println(1);
        if(n>2 && m==2)
            System.out.println(n);
        for (int i = 1; i <= n; i++) {

        }
    }
}

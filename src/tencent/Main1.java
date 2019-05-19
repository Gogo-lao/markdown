package tencent;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int minx=getCoin(n);
        System.out.println(minx);
    }
        private static int getCoin(int i) {
            int i64=i/64;
            int i16=(i%64)/16;
            int i4=(i%16)/4;
            int i1=(i%4)/1;
            return i64+i16+i4+i1;
        }
}

package weizhong;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[6];
        int[] a2 = {0, 5, 3, 1};
        for (int i=0; i<=5; i++) {
            a[i] = sc.nextInt();
        }
        int res = 0;
        res += a[5] + a[4] + a[3];
        res += (a[2] + 3) / 4;

        int temp1 = ((a[1] - a[3] * 5 - a2[a[2] % 4] + 8) / 9);
        if( temp1 > 0){
            res += temp1;
        }else{
            res += 0;
        }

        int temp2 = (a[0] - (36 * res  - 36 * a[5] - 25 * a[4] - 16 * a[3] - 9 * a[2] - 4 * a[1] + 35));
        if( temp2 > 0){
            res += temp2;
        }else{
            res += 0;
        }

        System.out.println(res);

    }

}

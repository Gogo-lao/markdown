package weizhong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] a = new int[6];
        for (int i = 0; i < 6; i++) {
            a[i] = in.nextInt();
        }

        int count = 0;
        count += a[5];
        count += a[4];a[0] = a[0]-(a[4]*11);
        count += a[3];a[1] = a[1]-(a[3]*5);
        int temp = a[2]%4;

        int res = a[2]/4;
        count += res;a[2]-=(res*4);
        if(temp>=3){

        }

        for (int i = 4; i >=0 ; i--) {
            count += a[i];
        }
    }

}

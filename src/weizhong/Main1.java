package weizhong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[][] {{1,0,0,0},{3,2,0,0},{4,5,6,0},{10,9,8,7}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(a[i][j] == n){
                    if(i == 0){
                        System.out.println(4+"/"+(j+1));
                    }
                    else if(i == 3){
                        System.out.println(1+"/"+(j+1));
                    }
                    else System.out.println((i+1)+"/"+(j+1));
                }
            }
        }

    }

}

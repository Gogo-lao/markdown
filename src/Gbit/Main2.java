package Gbit;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        char arr[] = new char[]{'2','0','1','8'};
        int count = 0;
        if (x < 2018) {
            System.out.println(0);
            return;
        }
        if (x == 2018) {
            System.out.println(1);
            return;
        }

        for (int i = 2018; i < x; i++) {
            boolean flag = false;
            char[] chars = String.valueOf(i).toCharArray();
            for (int j = 0; j < arr.length; j++) {
                flag = false;
                int k = j+1;
                for (; k < chars.length; k++) {
                    if (arr[j] == chars[k]){
                        flag = true;
                        break;
                    }
                }
            }
            if (flag){
                count++;
            }
        }

        System.out.println(count);

    }
}

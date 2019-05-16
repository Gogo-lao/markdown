package tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int num0 = 0;
        int num1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '0')
                num0++;
            else
                num1++;
        }
        System.out.println(Math.abs(num1-num0));
    }

}

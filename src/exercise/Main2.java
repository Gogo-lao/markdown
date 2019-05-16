package exercise;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int len = strs.length;
        int lirun = 0;
        for (int i = 0; i < len - 1; i++) {
            int temp1 = Integer.parseInt(strs[i]);
            for (int j = i+1; j < len; j++) {
                int temp2 = Integer.parseInt(strs[j]);
                lirun = (temp2 - temp1) > lirun?(temp2 - temp1):lirun;
            }

        }
        System.out.println(lirun);

    }
}
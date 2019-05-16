package exercise;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strs = in.nextLine();
        int len = strs.length();
        int count1 = 0,count2 = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if(strs.charAt(i) < strs.charAt(j))
                    count1++;
                else if(strs.charAt(i) > strs.charAt(j))
                    count2++;
            }
        }
        int res = count1>count2?count2:count1;
        System.out.println(res);
    }
}

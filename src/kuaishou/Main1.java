package kuaishou;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for(;n != 0;){
            n = (n - 1) & n;
            count++;
        }
        System.out.println(count);

    }
}


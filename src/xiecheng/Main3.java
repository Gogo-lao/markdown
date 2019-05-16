package xiecheng;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = 0;
        while (k++ != n){
            String str = in.next();
            System.out.println(str);
        }
    }
}
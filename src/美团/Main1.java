package 美团;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        for (int i = 0; i < x; i++) {
            int n = in.nextInt();
            boolean[] arr = new boolean[n*n];
            int k = 0;
            int count = 0;
            while (true){
                if ((k+n) > arr.length)
                    k -= n*n;
                if(!arr[k]) {
                    arr[k + n] = true;
                    k += n;
                    count++;
                }else break;
            }
            System.out.println(++count);
        }
        
    }
}

package 完美世界;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0,j = 0;
        int lose = 0, win = 0;
        while (i<n && j<n){
            if(a[i] == b[j]){
                i++;
                lose++;
            }
            else if(a[i] < b[j]){
                lose++;
                i++;
            }
            else{
                win++;
                i++;
                j++;
            }
        }
        int result = 100 * (win - lose);
        System.out.println(result);
    }
}
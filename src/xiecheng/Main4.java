package xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.substring(1,str.length()-1).split(",");
        int k = in.nextInt();
        if(k > strs.length)
            System.out.println(strs);
        int end = k;
        int start = 0;
        while (end < strs.length){
            swap(strs,start,end-1);
            start = end;
            end = end + k;
        }
        System.out.println(Arrays.toString(strs));

    }

    private static void swap(String[] strs,int start, int end){
        int i = start,j = end;
        while(i < j){
            String tempStr = strs[i];
            strs[i] = strs[j];
            strs[j] = tempStr;
            i++;j--;
        }
    }

}
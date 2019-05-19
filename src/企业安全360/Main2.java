package 企业安全360;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int main(int[] arr) {
        int[] flag = new int[128];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            flag[arr[i]]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (flag[i] >= 2)
                count++;
        }
        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int res;

        res = main(arr);
        System.out.println(String.valueOf(res));

    }
}

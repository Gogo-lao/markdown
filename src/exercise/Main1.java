package exercise;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int H = in.nextInt();

        int k = 1,N = strs.length;
        while (true)
        {
            int sum = 0, xx = 0;
            for (int i = 0; i < N; i++)
            {
                int temp = Integer.parseInt(strs[i]);
                xx = temp / k;
                if (temp % k != 0)
                    xx++;
                sum = sum + xx;
            }
            if (sum > H)
                k++;
            else
                break;
        }
        System.out.println(k);
    }
}

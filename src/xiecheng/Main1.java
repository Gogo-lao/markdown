package xiecheng;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(",");
        HashSet<String> hashSet = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < strings.length; i++) {
            flag = hashSet.add(strings[i]);
            if(!flag)
                System.out.println("true");
        }
        if(flag == true)
            System.out.println("false");
    }
}
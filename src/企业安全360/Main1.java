package 企业安全360;

import java.util.Scanner;

public class Main1 {
    public static int StringToInt(String s){
        int res = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean isNegative = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='.')
                break;
            if (i == 0 && s.charAt(i)=='-') {
                isNegative = true;
                continue;
            }else{
                if(s.charAt(i)>'9' || s.charAt(i)<'0'){
                    return 0;
                }
            }
            res *= 10;
            res += s.charAt(i) - '0';
        }
        return isNegative ? -res : res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(StringToInt(str));
    }
}



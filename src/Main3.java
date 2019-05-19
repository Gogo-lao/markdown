import java.util.Scanner;

/*
找零
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int y = 1024 - n;
        int money64 = 64,money16 = 16,money4 = 4,money1 = 1;
        for(int i=0;i<(y/money1);i++){
            for(int j=0;j<(y/money4);j++){
                for(int k=0;k<(y/money16);k++){
                    for(int m=0;m<(y/money64);m++){
                        int res = i*money1+j*money4+k*money16+m*money64;
                        if(res == y){
                            System.out.println(i+j+k+m);
                            return;
                        }
                    }
                }
            }
        }
    }
}

package kuaishou;


import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] ch = in.nextLine().split(",").toString().toCharArray();
    TreeSet<Character> treeSet = new TreeSet<>();
    for (int i = 0; i < ch.length; i++) {
        treeSet.add(ch[i]);
//        if(ch[i] != treeSet.pollLast()){
//            System.out.println("False");
//        }
    }
    for (int i = 0; i < ch.length; i++) {
        if(treeSet.pollFirst() != (Character) ch[i] ){
            System.out.println("False");
            return;
        }
    }
    System.out.println("True");
//    while (treeSet.iterator().hasNext()){
//        int i = 0;
//        char chi = treeSet.iterator().next();
//        if(chi != ch[i++]){
//            System.out.println("False");
//            return;
//        }
//    }
//    System.out.println("True");
//
    }
}


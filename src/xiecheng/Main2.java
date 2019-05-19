package xiecheng;

import java.util.Scanner;

public class Main2 {

    public class ListNode{
        int val;
        ListNode next;

        public void setVal(int val) {
            this.val = val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static ListNode reverseListK(ListNode list,int k){
        int index = k;
        ListNode tempList = list;
        for (int i = 0; i < index; i++) {
            tempList = tempList.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }
}
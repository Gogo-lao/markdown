package exercise.alibaba;

public class MergeTwoList {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode resultList = new ListNode(0);
        ListNode tempList = resultList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tempList.next = list1;
                list1 = list1.next;
            } else {
                tempList.next = list2;
                list2 = list2.next;
            }
            tempList = tempList.next;
        }
        if (list1 == null) {
            tempList.next = list2;
        } else {
            tempList.next = list1;
        }
        return resultList.next;
    }
}

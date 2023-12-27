package com.scaler.contest.tct_2;

/**
 * @created 26/09/23 4:11 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class Q5_Remove_Nth_Node_From_List_End {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null || B <= 0) return A;
        ListNode temp = new ListNode(0);;
        temp.next = A;
        ListNode fast = temp;
        ListNode slow = temp;
        for (int i = 0; i <= B; i++) {
            if (fast == null) {
                return A.next;
            }
            fast =  fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
}

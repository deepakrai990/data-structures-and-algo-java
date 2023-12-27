package com.scaler.core.java_3_advance_3.dsa_39_heaps_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:28 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Merge_K_Sorted_Lists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((A, B) -> Integer.compare(A.val, B.val));
        for (ListNode node : a) {
            if (node != null)
                minHeap.add(node);
        }

        ListNode ans = new ListNode(-1);
        ListNode ansTemp = ans;

        while (!minHeap.isEmpty()) {
            ListNode heapTemp = minHeap.poll();

            ansTemp.next = heapTemp;
            ansTemp = ansTemp.next;

            heapTemp = heapTemp.next;
            if (heapTemp != null)
                minHeap.add(heapTemp);
        }
        return ans.next;
    }
}

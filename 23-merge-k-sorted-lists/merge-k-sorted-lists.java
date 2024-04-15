

import static java.util.Collections.min;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        // priority queue:解法，放入每個頭節點
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head != null){
                minHeap.add(head);
            }
        }

        // pop node from minHeap, then attach to answer
        while(!minHeap.isEmpty()){
            ListNode cur = minHeap.poll();
            // put back the remaining if there are remaining node after cur
            p.next = cur;
            p = p.next;
            if(cur.next != null){
                minHeap.add(cur.next);
            }
        }
        return dummy.next;
    }
}
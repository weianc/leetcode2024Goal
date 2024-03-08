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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast != null){
            if(slow.val != fast.val){
                if(fast.next != null && fast.val == fast.next.val)
                {
                    // 1. fast == fast.next
                    // skip until fast != fast.next;
                    while(fast.next != null && fast.val == fast.next.val)
                    {
                        fast = fast.next;
                    }

                }
                else { 
                    // if fast != fast.next, then assign slow
                    slow.next = fast;
                    slow = slow.next;
                }
            }
            // move fast to fast.next
            fast = fast.next;
        }
        // complete the list with null in the end
        if(slow != null){
            slow.next = fast;
        }
        return dummy.next;
    }
}
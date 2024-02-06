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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        ListNode cur = head;
        
        while(cur != null){
            if(cur.val == prev.val){
                cur = cur.next;
            }
            else {
                // need to connect prev with cur
                prev.next = cur;
                // move prev to cur
                prev = cur;
                cur = cur.next;
            }
        }
        if(prev != null){
            prev.next = cur;
        }

        return dummy.next;
    }
}
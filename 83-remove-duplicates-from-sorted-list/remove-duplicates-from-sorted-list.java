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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            // 1. 當快指針和慢指針的數值不同時
            // 我們知道當前數字需要被保留
            // 移動慢指針並且賦值給他
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // complete slow pointer with null in the end
        if(slow != null){
            slow.next = null;
        }
        return dummy.next;
    }
}
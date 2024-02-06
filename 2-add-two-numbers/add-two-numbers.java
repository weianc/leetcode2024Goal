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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0; // 進位的數字
        
        while(l1 != null || l2 != null){
            // calculate digit value for the node each iteration
            int value = carry; // add carry over number from previous iteration
            if(l1 != null){
                value += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                value += l2.val;
                l2 = l2.next;
            }

            // update digit and carry number
            carry = value / 10;
            // digit value for current iteration
            value = value % 10;
            cur.next = new ListNode(value);
            // also move current pointer
            cur = cur.next;
        }

        // if carry is not zero after two list combine. Should add one more digit
        if(carry != 0){
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
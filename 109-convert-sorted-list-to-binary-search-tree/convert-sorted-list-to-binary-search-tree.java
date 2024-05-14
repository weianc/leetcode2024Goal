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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Soultion: Use concept of inorder traversal for BST is a sorted list
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int size = findSize(head);
        this.head = head;
        return constrcutBST(0, size-1);
    }

    private int findSize(ListNode head){
        ListNode p = head;
        int size = 0;
        while(p != null){
            p = p.next;
            size++;
        }
        return size;
    }

    private TreeNode constrcutBST(int l, int r){
        // 1. invalid case, recurssion end
        if(l > r){
            return null;
        }
        // split the array from mid
        int mid = (r + l) / 2;
        // inorder traversal: construct and traverse left tree
        TreeNode left = constrcutBST(l, mid-1); // mid is for current node

        // After construct left node, create current node with head pointer
        TreeNode cur = new TreeNode(this.head.val);
        cur.left = left;
        // move head pointer to next for construct right subtree
        head = head.next;

        // construct and traverse right tree
        cur.right = constrcutBST(mid + 1, r);
        return cur;
    }
}
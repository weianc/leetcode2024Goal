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
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    private void traverse(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >= low && root.val <= high){
            sum += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }
        else if (root.val < low){
            traverse(root.right, low, high);
        }
        else {
            traverse(root.left, low, high);
        }
    }
}
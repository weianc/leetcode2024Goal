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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }

    private void traverse(TreeNode root){
        if(root == null) return;

        
        int left = depth(root.left);
        int right = depth(root.right);
        // diameter不需加上root本人
        int diameter = left + right;

        // 更新全局最大路徑
        max = Math.max(max, diameter);

        traverse(root.left);
        traverse(root.right);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);

        return 1 + Math.max(left, right);
    }
}
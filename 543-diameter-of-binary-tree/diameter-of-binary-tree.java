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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode root){
        if(root == null) return 0;

        int left = longestPath(root.left);
        int right = longestPath(root.right);

        // 更新全局最大路徑
        // 直徑不需要加上root本人
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
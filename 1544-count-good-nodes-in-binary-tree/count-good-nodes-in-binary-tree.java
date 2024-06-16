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
    private int visibleCount = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, null, Integer.MIN_VALUE);
        return visibleCount;
    }

    private void dfs(TreeNode node, TreeNode prev, int pathMax){
        if(node == null) return;
        if(prev == null){
            visibleCount++;
        }
        else if (node.val >= prev.val && node.val >= pathMax){
            visibleCount++;
        }

        pathMax = Math.max(pathMax, node.val);
        dfs(node.left, node, pathMax);
        dfs(node.right, node, pathMax);
    }
}
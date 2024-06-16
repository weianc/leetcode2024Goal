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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int maxSoFar){
        int visibleCount = 0;
        if(root != null){
            if(root.val >= maxSoFar){
                visibleCount++;
                maxSoFar = root.val;
            }
            
            // calculate visibleCount from left and right child
            int leftVisibleCnt = dfs(root.left, maxSoFar);
            int rightVisibleCnt = dfs(root.right, maxSoFar);
            visibleCount += leftVisibleCnt;
            visibleCount += rightVisibleCnt;
        }
        return visibleCount;
    }
}
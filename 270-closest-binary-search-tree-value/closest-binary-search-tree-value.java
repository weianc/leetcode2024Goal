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
    // Only need to record node value
    // because we can get difference from node.val and target
    int nodeVal = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return nodeVal;
    }

    private void traverse(TreeNode root, double target){
        if(root == null) return;
        if (Math.abs(nodeVal - target) > Math.abs(root.val - target)){
            nodeVal = root.val;
        }
        else if (Math.abs(nodeVal - target) == Math.abs(root.val - target)){
            if (nodeVal > root.val){
                nodeVal = root.val;
            }
        }

        if (root.val > target){
            // 必定從左子樹找答案
            traverse(root.left, target);
        }
        else if (root.val < target){
            traverse(root.right, target);
        }
    }
}
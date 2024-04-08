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
    double diff = Double.MAX_VALUE;
    int value = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return value;
    }

    private void traverse(TreeNode root, double target){
        if(root == null) return;
        if(diff > Math.abs(root.val - target)){
            diff = Math.abs(root.val - target);
            value = root.val;
        }
        else if (diff == Math.abs(root.val - target)){
            if (value > root.val){
                value = root.val;
            }
        }

        if (root.val > target){
            if(root.left != null){
                traverse(root.left, target);
            }
            else {
                // no left child
                if(diff > Math.abs(root.val - target)){
                    diff = Math.abs(root.val - target);
                    value = root.val;
                }
                else if (diff == Math.abs(root.val - target)){
                    if (value > root.val){
                        value = root.val;
                    }
                }
            }
        }
        else if (root.val < target){
            if(root.right != null){
                traverse(root.right, target);
            }
            else {
                if(diff > Math.abs(root.val - target)){
                    diff = Math.abs(root.val - target);
                    value = root.val;
                }
                else if (diff == Math.abs(root.val - target)){
                    if (value > root.val){
                        value = root.val;
                    }
                }
            }
        }
    }
}
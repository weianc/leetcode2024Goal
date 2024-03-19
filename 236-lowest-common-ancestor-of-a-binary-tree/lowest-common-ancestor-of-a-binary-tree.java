/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        // 找到目標，回傳當前root
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        // find left Tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // check if left and right has result, then we know root is the LCA
        if(left != null && right != null) return root;

        return left != null ? left : right;

    }
}
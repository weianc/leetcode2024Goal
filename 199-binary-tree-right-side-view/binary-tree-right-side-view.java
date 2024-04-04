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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res, int depth){
        // preorder traversal: root, right, left
        if(root == null) return;
        if(depth >= res.size()){
            // 表示本層還沒加過
            res.add(root.val);
        }
        if(root.right != null){
            traverse(root.right, res, depth + 1);
        }

        if(root.left != null){
            traverse(root.left, res, depth + 1);
        }
    }
}
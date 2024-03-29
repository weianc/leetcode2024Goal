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
    public int sumNumbers(TreeNode root) {
        // 40 + 495 + 491 = 1026
        if(root == null) return 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        traverse(root, 0, list);
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }

    private void traverse(TreeNode root, int acc, List<Integer> list){
        acc = acc * 10 + root.val;
        if(root.left == null && root.right == null){
            list.add(acc);
            return;
        }
        if(root.left != null){
            traverse(root.left, acc, list);
        }
        if(root.right != null){
            traverse(root.right, acc, list);
        }
    }
}
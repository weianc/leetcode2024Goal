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
    public boolean isCompleteTree(TreeNode root) {
        // 核心思想:是否在null節點出現之後又出現null
        Queue<TreeNode> q = new LinkedList<>();
        boolean nullNodePresent = false;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    // indicate that this is not a complete tree
                    if(nullNodePresent) {
                        return false;
                    }
                    q.offer(cur.left);
                }
                else {
                    // cur.left is null???
                    if(!nullNodePresent){
                        nullNodePresent = true;
                    }
                }

                if(cur.right != null){
                    // indicate that this is not a complete tree
                    if(nullNodePresent) {
                        return false;
                    }
                    q.offer(cur.right);
                }
                else {
                    // cur.left is null???
                    if(!nullNodePresent){
                        nullNodePresent = true;
                    }
                }
            }
        }
        return true;
    }
}
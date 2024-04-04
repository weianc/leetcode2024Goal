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
    // BFS solution
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int layerSize = q.size();
            for(int i = 0; i < layerSize; i++){
                // take the first one
                TreeNode cur = q.poll();
                if(i == 0){
                    res.add(cur.val);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
            }
        }
        return res;
    }
}
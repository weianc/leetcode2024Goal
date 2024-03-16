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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();

        // add root to the Queue
        nodeQ.add(root);
        colQ.add(0);

        while(!nodeQ.isEmpty()){
            TreeNode curNode = nodeQ.poll();
            int num = colQ.poll();
            if(!map.containsKey(num)){
                List<Integer> list = new ArrayList<>();
                list.add(curNode.val);
                map.put(num, list);
            }
            else {
                List<Integer> list = map.get(num);
                list.add(curNode.val);
                map.put(num, list);
            }

            // traverse left child
            if(curNode.left != null){
                nodeQ.add(curNode.left);
                colQ.add(num - 1);
            }

            // traverse right child
            if(curNode.right != null){
                nodeQ.add(curNode.right);
                colQ.add(num + 1);
            }
        }

        // put content in map to res
        for(Integer key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }


}
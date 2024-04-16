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
    List<Triple> subList = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(0, 0, root);
        // 根據subList裡頭得到的節點進行排序
        // 由於是vertical order, 先根據column排序
        // 相同column再根據row排序
        Collections.sort(subList, (a, b) -> 
        {
            if(a.col == b.col && a.row == b.row){
                return a.node.val - b.node.val;
            }
            else if(a.col == b.col) {
                return a.row - b.row;
            }
            else {
                return a.col - b.col;
            }
        });

        int col = 0;
        if(subList.size()!= 0){
            col = subList.get(0).col;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < subList.size(); i++){
            Triple cur = subList.get(i);
            int c_cur = cur.col;
            if(col == c_cur){
                list.add(cur.node.val);
            }
            else {
                // 1. append prev list to res
                res.add(new ArrayList<>(list));
                // 2. reset list
                list.clear();
                col++;
                // 3. add cur
                list.add(cur.node.val);
            }
        }

        // add the last list
        if(list.size()!=0){
            res.add(new ArrayList<>(list));
        }

        return res;
    }

    private void traverse(int row, int col, TreeNode root){
        if(root == null) return;
        traverse(row + 1, col - 1, root.left);
        // add node 
        subList.add(new Triple(root, row, col));
        traverse(row + 1, col + 1, root.right);
    }

    class Triple {
        public int row, col;
        public TreeNode node;

        public Triple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
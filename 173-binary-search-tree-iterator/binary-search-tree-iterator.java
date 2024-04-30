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
class BSTIterator {
    private Stack<TreeNode> stk = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeftToStack(root);
    }
    
    public int next() {
        TreeNode p = stk.pop();
        pushLeftToStack(p.right);
        return p.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    private void pushLeftToStack(TreeNode p){
        while(p != null){
            stk.push(p);
            p = p.left;
        }
        return;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
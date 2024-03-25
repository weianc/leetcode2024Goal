/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    // 基本邏輯: 先找出最小的node，作為head
    // 1. last == null，表示head也是空，將當前node指定為head/last
    // 2. last != null，則需要將當前node與last相接
    // last.right = node
    // node.left = last
    private Node head = null;
    private Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        traverse(root);
        // connect last and head
        last.right = head;
        head.left = last;
        return head;
    }

    private void traverse(Node root) {
        if(root == null){
            return;
        }

        // left node right
        traverse(root.left);
        if(last == null){
            head = root;
        }
        else {
            // connect last and root
            last.right = root;
            root.left = last;
        }
        last = root;
        traverse(root.right);
    }
}
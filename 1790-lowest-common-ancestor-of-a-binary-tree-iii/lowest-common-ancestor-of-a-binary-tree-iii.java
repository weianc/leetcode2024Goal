/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    // 这道题其实不是公共祖先的问题，而是单链表相交的问题
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p;
        Node p2 = q;

        while(p1.val != p2.val){
            p1 = p1.parent;
            p2 = p2.parent;
            // 相遇點：經過這樣的操作，p1 和 p2 會在 LCA 處相遇。
            // 這是因為兩個指針都會遍歷相同數量的節點：p 到 LCA 的路徑加上 q 到 LCA 的路徑。
            if(p1 == null){
                p1 = q;
            }
            if(p2 == null){
                p2 = p;
            }
        }
        return p1;
    }
}
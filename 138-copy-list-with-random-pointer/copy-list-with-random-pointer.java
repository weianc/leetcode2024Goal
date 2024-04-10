/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // 需要一個visited map紀錄拜訪過的節點
    private Map<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        // 1. 遞迴出口
        if(head == null) return null;
        if(nodeMap.containsKey(head)){
            return nodeMap.get(head);
        }

        // 2. 創造copy節點 , preorder traversal
        Node copy = new Node(head.val);
        nodeMap.put(head, copy);

        // 3. 接下來分別traverse next and random pointer
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);

        // 4. 回傳head的對應節點
        return copy;

    }
}
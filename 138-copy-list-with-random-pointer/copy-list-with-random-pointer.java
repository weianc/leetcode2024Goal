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
    // DFS
    public Node copyRandomList(Node head) {
        // 对于数据结构复制，甭管他怎么变，你就记住最简单的方式：一个哈希表 + 两次遍历。
        // hashmap: 原始節點跟新節點的mapping
        Map<Node, Node> nodeMapping = new HashMap<>();
        Node cur = head;
        // 第一輪: 複製節點
        while(cur != null){
            Node copy = new Node(cur.val);
            nodeMapping.put(cur, copy);
            cur = cur.next;
        }

        // 第二輪: 複製pointer
        for(Node ori : nodeMapping.keySet()){
            Node copyNode = nodeMapping.get(ori);
            Node copyNext = nodeMapping.get(ori.next);
            Node copyRandom = nodeMapping.get(ori.random);
            copyNode.next = copyNext;
            copyNode.random = copyRandom;
        }

        // return new head
        return nodeMapping.get(head);
    }
}
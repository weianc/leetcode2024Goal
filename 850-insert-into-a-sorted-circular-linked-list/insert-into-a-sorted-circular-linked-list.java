/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node toInsert = new Node(insertVal);
        if (head == null) {
            head = toInsert;
            head.next = head;
            return head;
        }

        Node cur = head;
        Node next = head.next;

        boolean inserted = false;
        boolean firstHeadVisited = false;

        // loop through the list for 1 cycle
        // case 1: cur <= toInsert <= next;
        // case 2: max(tail) <= toInsert || min() >= toInsert
        // 2.1: cur <= toInsert && next <= toInsert
        // 2.2: cur >= toInsert && next >= toInsert
        while (cur != head || !firstHeadVisited) {
            firstHeadVisited = true;
            // case 1: regular case
            if (cur.val <= insertVal && insertVal <= next.val) {
                cur.next = toInsert;
                toInsert.next = next;
                inserted = true;
            } else if (cur.val > next.val) { // reach to tail
                // case 2
                if (cur.val <= insertVal && next.val <= insertVal ||
                        cur.val >= insertVal && next.val >= insertVal) {
                    // tail is cur
                    cur.next = toInsert;
                    toInsert.next = next;
                    inserted = true;
                }
            }

            if (!inserted) {
                cur = cur.next;
                next = next.next;
            } else {
                //cur.next = new Node(insertVal, next);
                return head;
            }
        }

        // out of loop
        // if inserted still false
        // case 3: 
        // 假设链表是 3 -> 3 -> 3 -> 3，你要插入 5。
        if(!inserted){
            cur.next = new Node(insertVal, next);
        }
        return head;
    }
}
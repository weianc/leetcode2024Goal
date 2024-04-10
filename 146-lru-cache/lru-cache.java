class LRUCache {
    // 1. double linked list
    // 2. HashMap
    private Node head;
    private Node rear;
    private int size;
    private Map<Integer, Node> nodeMap;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.nodeMap = new HashMap<>();
        this.head = new Node(0, 0);
        this.rear = new Node(0, 0);
        head.next = rear;
        rear.prev = head;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node node = nodeMap.get(key);
        // should delete node from list firstly
        deleteNode(node);
        moveNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            // update value of the node;
            Node node = nodeMap.get(key);
            // need to remove node from original list
            deleteNode(node);
            node.val = value;
            moveNodeToHead(node);
            return;
        }

        // check the size of the list
        if(nodeMap.size() == size){
            // remove node before rear
            Node last = rear.prev;
            int removeKey = last.key;
            deleteNode(last);
            System.out.println(removeKey);
            nodeMap.remove(removeKey);
        }
        // put new node
        Node newNode = new Node(key, value);
        moveNodeToHead(newNode);
        nodeMap.put(key, newNode);
    }

    private void moveNodeToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.val = value;
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
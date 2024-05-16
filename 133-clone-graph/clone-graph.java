/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Solution 2: Optimize DFS with single loop
    // 紀錄原節點到clone node的mapping
    private Map<Node, Node> nodeMap = new HashMap<>();
    // 紀錄DFS遍歷過的節點，防止走回頭路
    private Set<Integer> visited = new HashSet<>();
    public Node cloneGraph(Node node) {
        traverse(node);
        return nodeMap.get(node);
    }

    private void traverse(Node node){
        if(node == null){
            return;
        }
        if(visited.contains(node.val)){
            return;
        }

        // preorder traversal position
        // 1. 標記當前node為已訪問
        visited.add(node.val);
        
        //  2. clone node
        if(!nodeMap.containsKey(node)){
            nodeMap.put(node, new Node(node.val));
            // no need to initialize neighbors field. 
            // This is implemented in constructor
        }
        Node cloneNode = nodeMap.get(node);
        List<Node> nb = node.neighbors;
        for(Node n : nb) {
            // construct n node first
            traverse(n);
            // assign neighbor to current node
            Node copyNeighbor = nodeMap.get(n);
            cloneNode.neighbors.add(copyNeighbor);
        }
    }
}
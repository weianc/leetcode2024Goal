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
    private Map<Node, Node> nodeMap = new HashMap<>();
    private Set<Integer> visited = new HashSet();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        traverse(node);
        traverseForNeighbor(node);
        return nodeMap.get(node);
    }

    private void traverseForNeighbor(Node node){
        visited.add(node.val);
        Node copy = nodeMap.get(node);
        copy.neighbors = new ArrayList<>();
        List<Node> nb = node.neighbors;
        for(Node n : nb){
            Node copyNeighbor = nodeMap.get(n);
            copy.neighbors.add(copyNeighbor);
            if(!visited.contains(n.val)){
                traverseForNeighbor(n);
            }
        }
    }

    private void traverse(Node node){
        if(nodeMap.containsKey(node)){
            return;
        }

        // clone node first
        nodeMap.put(node, new Node(node.val));
        List<Node> neighborNodes = node.neighbors;
        for(int i = 0; i < neighborNodes.size(); i++){
            Node cur = neighborNodes.get(i);
            traverse(cur);
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        // build nodeToParent map
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        // [important]我們需要visited set去檢查當前節點拜訪過了沒
        // 因為現在不同於binary tree的traverse只是往下,
        // 往parent拜訪的路上非常有可能重複拜訪已經拜訪過的節點
        Set<TreeNode> visited = new HashSet<>();
        buildParentMap(root, null, nodeToParentMap);

        // start from target for BFS
        int level = 0; // 0 start from target
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
            if(level == k) {
                // pop all nodes from Queue
                PullNodesAtLevelK(q, res);
                break;
            }
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                // 1. left tree
                if(cur.left != null && !visited.contains(cur.left)){
                    q.offer(cur.left);
                    visited.add(cur.left);
                }

                // 2. right tree
                if(cur.right != null && !visited.contains(cur.right)){
                    q.offer(cur.right);
                    visited.add(cur.right);
                }

                // 3. parent direction
                if(nodeToParentMap.containsKey(cur) && nodeToParentMap.get(cur) != null && 
                !visited.contains(nodeToParentMap.get(cur))){
                    q.offer(nodeToParentMap.get(cur));
                    visited.add(nodeToParentMap.get(cur));
                }
            }

            // one level complete, start to process next level distance 
            level++;
        }
        return res;
    }

    private void PullNodesAtLevelK(Queue<TreeNode> q, List<Integer> res){
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            res.add(cur.val);
        }
    }

    private void buildParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(root == null) return;
        // add to key set
        map.put(root, parent);

        // left
        buildParentMap(root.left, root, map);
        // right
        buildParentMap(root.right, root, map);
    }
}
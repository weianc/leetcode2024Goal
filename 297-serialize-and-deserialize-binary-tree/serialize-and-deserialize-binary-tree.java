/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    private int deserializeIdx;
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    private void serializeDFS(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("null");
            sb.append(',');
            return;
        }
        // add current val
        sb.append(root.val);
        sb.append(',');
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deserializeIdx = 0;
        String[] arr = data.split(",");
        return deserializeDFS(arr);
    }

    private TreeNode deserializeDFS(String[] arr){
        if(deserializeIdx == arr.length || arr[deserializeIdx].equals("null")){
            if(deserializeIdx < arr.length){
                deserializeIdx++;
            }
            return null;
        }

        // construct node
        TreeNode node = new TreeNode(Integer.parseInt(arr[deserializeIdx]));
        deserializeIdx++;
        // left 
        node.left = deserializeDFS(arr);
        node.right = deserializeDFS(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
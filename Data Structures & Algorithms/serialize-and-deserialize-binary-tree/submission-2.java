/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("#");
                sb.append(",");
                continue;
            }
            sb.append(temp.val);
            sb.append(",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();

        String[] arr = data.split(",");
        if (arr[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode temp = q.poll();
            if (!arr[i].equals("#")) {
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(temp.left);
            }
            ++i;
            if (i < arr.length && !arr[i].equals("#")) {
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(temp.right);
            }
        }
        return root;
    }
}

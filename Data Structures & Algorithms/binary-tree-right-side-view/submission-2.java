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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n - 1; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            TreeNode last = q.poll();
            if (last.left != null) {
                q.offer(last.left);
            }
            if (last.right != null) {
                q.offer(last.right);
            }
            ans.add(last.val);
        }
        return ans;
    }
}

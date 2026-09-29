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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int k = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

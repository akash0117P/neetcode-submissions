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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int k = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);

                temp.add(curr.val);
            }
            ans.add(temp);
        }
        return ans;
    }
}

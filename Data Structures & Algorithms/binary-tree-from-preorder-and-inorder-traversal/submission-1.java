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
    TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd,
        Map<Integer, Integer> mp) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = mp.get(preorder[preStart]);
        int left = inRoot - inStart;

        root.left =
            build(preorder, inorder, preStart + 1, preStart + left + 1, inStart, inRoot - 1, mp);

        root.right = build(preorder, inorder, preStart + left + 1, preEnd, inRoot + 1, inEnd, mp);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();

        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1, mp);
    }
}

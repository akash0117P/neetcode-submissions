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
    TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> mp, int preStart,
        int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd && inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = mp.get(preorder[preStart]);
        int inLeft = inRoot - inStart;

        root.left =
            build(preorder, inorder, mp, preStart + 1, preStart + inLeft, inStart, inRoot - 1);
        root.right = build(preorder, inorder, mp, preStart + inLeft + 1, preEnd, inRoot + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();

        int n = preorder.length;
        int m = inorder.length;

        for (int i = 0; i < m; i++) {
            mp.putIfAbsent(inorder[i], i);
        }
        return build(preorder, inorder, mp, 0, n - 1, 0, m - 1);
    }
}

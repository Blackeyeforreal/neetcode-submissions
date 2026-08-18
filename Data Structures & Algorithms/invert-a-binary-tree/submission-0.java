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
    public TreeNode invertTree(TreeNode root) {
        TreeNode ans = root;
        if (root==null) return null;

        Queue<TreeNode> children = new LinkedList<>();
        children.offer(root);
        while (!children.isEmpty()) {
            TreeNode child = children.poll();
       //     if (child.left != null && child.right != null) {
                TreeNode temp = child.left;
                child.left = child.right;
                child.right = temp;
          //  }
            if (child.left != null)
                children.offer(child.left);
            if (child.right != null)
                children.offer(child.right);
        }

        return ans;
    }
}

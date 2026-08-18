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
    public int maxDepth(TreeNode root) {
        if ( root==null) return 0;
        Queue<TreeNode>  children = new LinkedList<>();
        int ans =0 ;
        children.offer(root);
        while (!children.isEmpty()) {
            ans++;
            int n = children.size();
            for (int i = 0; i < n; i++) {
                TreeNode child = children.poll();

                if ( child.left !=null) 
                    children.offer(child.left);
                if (child.right !=null)
                    children.offer(child.right);

            }
        }
        return ans ; 
    }
}

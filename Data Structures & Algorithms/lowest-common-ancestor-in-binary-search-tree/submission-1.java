class Solution {
    TreeNode lca = null;

    private boolean dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return false;
        }

        boolean left = dfs(cur.left, p, q);
        boolean right = dfs(cur.right, p, q);

        boolean current = (cur == p || cur == q);

        // Two of the three parts contain p and q
        if ((current && left) ||
            (current && right) ||
            (left && right)) {
            lca = cur;
        }

        return current || left || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        dfs(root, p, q);
        return lca;
    }
}
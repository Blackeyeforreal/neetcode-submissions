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

       
        Queue<TreeNode> check = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
         if ( root == null) return ans ;
        check.offer(root);
        ans.add(Arrays.asList(root.val));
        while(!check.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int n = check.size();
            for(int i = 0 ;i <n;i++){
                TreeNode child = check.poll();

                if (child.left!= null){
                    temp.add(child.left.val);
                    check.offer(child.left);
                }
                if ( child.right != null){
                    temp.add(child.right.val);
                    check.offer(child.right);
                }

            }
            if ( temp.size()>0)
            ans.add(temp);
        }
        return ans;
    }
}

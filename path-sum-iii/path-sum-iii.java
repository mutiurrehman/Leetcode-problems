/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {     }
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        
        helper(root,sum);
        return count;
    }

    int count=0;
    
    public void helper(TreeNode root, int sum){
        if(root==null)
        return;
        
        dfs(root, 0, sum);
        helper(root.left,sum);
        helper(root.right,sum);
        
    }
    public void dfs(TreeNode root, int sum, int target){
        if(root==null)
            return;
        
        sum+=root.val;
        if(sum==target)
            count++;
        
        dfs(root.left, sum,target);
        dfs(root.right, sum, target);
    }
}

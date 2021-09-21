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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        
        helper(root,targetSum);
        return count;
    }
    
    public void helper(TreeNode root, int t){
        if(root==null)
            return;
        
        
        dfs(root,t,0);
        helper(root.left, t);
        helper(root.right,t);
    }
    
    int count=0;
    public void dfs(TreeNode root, int t, int sum){
       

        if(root==null){
            return;
        }
        
        if(root==null)
            return;
        
        sum+=root.val;
        
        if(sum==t)
            count++;
        
        dfs(root.left, t, sum);
        dfs(root.right, t,sum);
    }
}
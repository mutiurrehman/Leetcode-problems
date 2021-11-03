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
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }
    
    int ans=0;
    public void helper(TreeNode root, int temp){
        if(root==null)
            return;
        
        temp = temp*10 + root.val;
        if(root.left==null && root.right==null){
            ans+=temp;
            return;
        }
        
        helper(root.left,temp);
        helper(root.right, temp);
    }
}
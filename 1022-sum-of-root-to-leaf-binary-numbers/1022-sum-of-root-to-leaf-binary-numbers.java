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
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return ans;
    }
    
    int ans=0;
    public void helper(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        
        sb.append(root.val);
        if(root.left==null && root.right == null){
            ans+=Integer.parseInt(sb.toString(),2);
        }
        
        helper(root.left, sb);
        helper(root.right,sb);
        
        sb.deleteCharAt(sb.length()-1);
    }
}
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
    public int goodNodes(TreeNode root) {
        
        helper(root,root.val);
        return count;
    }
    
    int count=0;
    public void helper(TreeNode root, int cur){
        if(root== null)
            return;
        
        if(root.val>=cur){
            count++;
            cur=root.val;
        }
        
        helper(root.left,cur);
        helper(root.right,cur);
        
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }
    
    TreeNode ans = null;
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        
        
        
        int f = helper(root.left,p,q) ? 1 : 0;
        int s = helper(root.right,p,q)? 1 : 0;
        int t = (root == p|| root==q) ? 1 : 0;
        
        if((f+s+t)>=2){
            this.ans = root;   
        }
        
        return (f+s+t)>0;
    }
}
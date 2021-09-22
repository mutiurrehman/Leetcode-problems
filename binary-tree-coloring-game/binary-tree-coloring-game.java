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
    int left, right, val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        
        count(root);
        if(left>n/2 || right > n/2)
            return true;
        
        if((left+right+1)<=(n)/2)
            return true;
        
        return false;
        
    }
    
    public int count(TreeNode root){
        if(root==null)
            return 0;
        int l = count(root.left);
        int r = count(root.right);
        
        if(root.val == val){
            left = l;
            right = r;
        }
        
        return l+r+1;
    }
}
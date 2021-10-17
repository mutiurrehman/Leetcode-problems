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
    int ans = 0;
    public int minCameraCover(TreeNode root) {
    if(count(root)==0)
            ans++;
        return ans;
    }
    
    public int count(TreeNode root){
        if(root==null)
            return -1;
        
        int l = count(root.left);
        int r = count(root.right);
        
        if(l==0||r==0){
            ans++;
            return 1;
        }
        
        if(l==1 || r==1)
            return 2;
        
        return 0;
    }
}
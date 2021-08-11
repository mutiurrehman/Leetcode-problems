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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
              if(d==1){
                  TreeNode t= new TreeNode(v);
                  t.left=root;
                  return t;
              }
        helper(v,root,1,d);
        return root;
        }
    public void helper(int val,TreeNode root,int depth,int n){
        if(root==null)
            return;
        if(depth==n-1){
            TreeNode t=root.left;
            root.left= new TreeNode(val);
            root.left.left=t;
            t=root.right;
            root.right= new TreeNode(val);
            root.right.right=t;
        }else{
            helper(val,root.left,depth+1,n);
            helper(val,root.right,depth+1,n);
        }
        
        
    }
    
    
}
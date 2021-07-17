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
    List<List<Integer>> res ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        res = new ArrayList<>();
        helper(root,targetSum,new ArrayList<Integer>());
        return res;
    }
    
    public void helper(TreeNode root, int B, ArrayList<Integer> temp){
        if(root==null)
            return;
        B=B-root.val;
        temp.add(root.val);
        if(B==0 && root.left==null && root.right==null){
            res.add(new ArrayList<Integer>(temp));
        }
        
        helper(root.left,B,temp);
        helper(root.right,B,temp);
        
        temp.remove(temp.size()-1);
        B=B+root.val;
    }
}
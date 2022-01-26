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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(ans);
        return ans;
    }
    List<Integer> ans = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null)
            return;
        
        
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
            
    }
}
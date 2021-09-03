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
     ArrayList<Integer> vals;
    public boolean isValidBST(TreeNode root) {
        vals= new ArrayList<Integer>();
 inOrder(root);
 
		for (int i = 0; i < vals.size() - 1; i++) {
			if (vals.get(i) >= vals.get(i + 1) )
				return false;}
			return true;
    }
  
    
   private void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		vals.add(node.val);
		inOrder(node.right);
	}

    
}
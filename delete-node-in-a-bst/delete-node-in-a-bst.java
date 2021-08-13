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
    public TreeNode deleteNode(TreeNode root, int key) {
      if(root==null)
          return null;
       else if(key<root.val){
           root.left=deleteNode(root.left,key);
       }
     else if(key>root.val){
           root.right=deleteNode(root.right,key);
       }
        else{
            if(root.left == null && root.right == null) { 
			root = null;
		}
            else if(root.left == null) {
		//	TreeNode temp = root;
			root = root.right;
			
		}
             else if(root.right == null) {
			//TreeNode temp = root;
			root = root.left;
			
		}
            else { 
			TreeNode temp = min(root.right);
			root.val = temp.val;
			root.right = deleteNode(root.right,temp.val);
		}
            
            
        }
        return root;
    }
    private TreeNode min(TreeNode node) {

		if (node.left == null) {
			return node;
		}

		return min(node.left);

	}
    
}
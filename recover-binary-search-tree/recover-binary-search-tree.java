public class Solution {
    
    TreeNode first = null;
    TreeNode second = null;
    
    TreeNode prev =null;
    
    public void recoverTree(TreeNode root) {
           if(root==null) return;
        traverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null)
            return;
            
        traverse(root.left);
        
        if (first == null &&  (prev==null ||prev.val >= root.val)) {
            first = prev;
        }
    
        if (first != null && prev.val >= root.val) {
            second = root;
        }        
        prev = root;


        traverse(root.right);
}
}
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
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(bfs.peek()!=null){
            TreeNode curr = bfs.poll();
            bfs.add(curr.left);
            bfs.add(curr.right);
        }
        
        while(!bfs.isEmpty() && bfs.peek()==null){
            bfs.poll();
        }
        
        return bfs.isEmpty();
    }
}
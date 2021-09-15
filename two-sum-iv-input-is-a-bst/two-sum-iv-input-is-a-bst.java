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

class bstIterator{
    Stack<TreeNode> st;
    boolean reverse;
    public bstIterator(TreeNode root,boolean reverse){
        st = new Stack<>();
        this.reverse = reverse;
        pushAll(root);
    }
    
    public int next(){
        TreeNode curr = st.pop();
        if(!reverse)
        pushAll(curr.right);
        else
            pushAll(curr.left);
        return curr.val;
    }
    
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            root= !reverse? root.left:root.right;
        }
    }
}


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        bstIterator leftItr = new bstIterator(root, false);
        bstIterator rightItr = new bstIterator(root, true);
        
        int left = leftItr.next(), right = rightItr.next();
        while(left<right){
            if(left+right==k)
                return true;
            if(left+right<k)
                left = leftItr.next();
            else
                right = rightItr.next();
        }
        
        return false;
    }
}
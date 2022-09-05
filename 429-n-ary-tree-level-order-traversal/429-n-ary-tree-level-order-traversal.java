/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans =  new ArrayList<List<Integer>>();
        if(root==null)
            return ans;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp= new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                
                Node node=q.poll();
                temp.add(node.val);
                if(node.children!=null){
                    for(Node v:node.children){
                        q.add(v);
                    }
                }
                
            }
            ans.add(temp);
        }
        return ans;
    }
}
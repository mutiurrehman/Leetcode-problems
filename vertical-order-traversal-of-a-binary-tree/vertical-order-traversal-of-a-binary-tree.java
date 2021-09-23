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

class Node{
    int y;
    TreeNode node;
    Node(TreeNode node, int y){
        this.node = node;
        this.y = y;
    }
}

class Pair{
    int level;
    int val;
    Pair(int val, int level){
        this.val = val;
        this.level = level;
    }
}

class Solution {
    
    public void print(List<Pair> temp){
        for(Pair c: temp){
            System.out.print(c.val+" " +c.level+" ");
        }
        System.out.println("potty");
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0));
        int level=0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(curr.node.left!=null)
                    q.add(new Node(curr.node.left,curr.y-1));

                if(curr.node.right!=null)
                    q.add(new Node(curr.node.right,curr.y+1));

                if(map.containsKey(curr.y)){
                    map.get(curr.y).add(new Pair(curr.node.val,level));

                }
                else{
                    List<Pair> temp = new ArrayList<>();
                    temp.add(new Pair(curr.node.val,level));
                    map.put(curr.y,temp);
                }
            }
        }
        
       
        List<List<Integer>> ans = new ArrayList<>();
        for(int key: map.keySet()){
           List<Pair> temp = map.get(key);
            Collections.sort(temp, new Comparator<Pair>(){
                public int compare(Pair f, Pair s){
                    if(f.level<s.level)
                        return -1;
                    if(f.level > s.level)
                        return 1;         
                    
                    return (f.val) - (s.val);
                }
            });
            
            List<Integer> toAdd = new ArrayList<>();
            for(int i=0;i<temp.size();i++){
                toAdd.add(temp.get(i).val);
            }
            ans.add(toAdd);
        }
        
        return ans;
    }
}
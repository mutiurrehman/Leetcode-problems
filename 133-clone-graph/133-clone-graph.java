/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        Set<Node> vis = new HashSet<>();
        return dfs(node,vis);
    }
    
    public Node dfs(Node node, Set<Node> visited){
        if(visited.contains(node))
            return map.get(node);
        
        Node clone = new Node(node.val);
        visited.add(node);
        map.put(node,clone);
        for(Node c: node.neighbors){
            Node nbrClone = dfs(c, visited);
            clone.neighbors.add(nbrClone);
        }
        
        return clone;
    }
        
}
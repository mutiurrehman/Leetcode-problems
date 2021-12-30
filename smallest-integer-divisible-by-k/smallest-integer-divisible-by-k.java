class Solution {
    public int smallestRepunitDivByK(int A) {
    Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[A];
        q.add(new Node("1", 1 % A));
        visited[1%A] = true;
        
        while(!q.isEmpty()){
            Node curr = q.remove();
            
            if(curr.rem==0)
            return curr.value.length();
            
            int n2 = (curr.rem*10+1)%A;
            
            if(!visited[n2]){
                q.add(new Node(curr.value+"1",n2));
                visited[n2]=true;
            }
         
            
        }
        
        return -1;
    }
    
    class Node{
        String value;
        int rem = -1;
        
        Node(String value, int rem){
            this.value=value;
            this.rem=rem;
        }
    }
}
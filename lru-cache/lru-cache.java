class Node{
    Node next, prev;
    int key, val;
    Node(int key, int value){
        this.key = key;
        this.val = value;
    }
}

class LRUCache {

    
    Node head, tail;
    HashMap<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
            
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
        }
        
        if(map.size()== capacity){
            remove(tail.prev);
            
        }
        
        Node toAdd = new Node(key, value);
        add(toAdd);
    }
    
    public void remove(Node root){
        map.remove(root.key);
        root.prev.next = root.next;
        root.next.prev = root.prev;
    }
    
    public void add(Node root){
        map.put(root.key,root);
        Node next = head.next;
        head.next = root;
        root.prev = head;
        next.prev = root;
        root.next = next;
    }
    
    public void print(Node node){
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
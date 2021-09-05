class LockingTree {

    
    int[] parent;
    ArrayList<Integer> arr[];
    HashMap<Integer, Integer> locked;
    public LockingTree(int[] parent) {
        
        int n = parent.length;
        arr = new ArrayList[n];
        locked = new HashMap<>();
        
        this.parent = parent;
        
        for(int i=0;i<n;i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=1;i<n;i++){
            arr[parent[i]].add(i);
        }
        
        
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num))
            return false;
        
        locked.put(num,user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num) || locked.get(num)!=user)
            return false;
        
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num))
            return false;
        
        boolean check = dfs(num,new HashSet<Integer>());
        if(!check)
            return false;
        
        int curr = num;
        while(curr!=-1){
            curr = parent[curr];
            if(locked.containsKey(curr))
                return false;
            
        }
        
        unlock(num,user, new HashSet<Integer>());
        locked.put(num,user);
        return true;
    }
    
    public boolean unlock(int src, int user, HashSet<Integer> set){
        if(locked.containsKey(src))
            locked.remove(src);
        
        if(set.contains(src))
            return false;
        
        set.add(src);
        for(int i : arr[src]){
            if(unlock(i,user,set))
                return true;
        }
        
        return false;
    }
    
    public boolean dfs(int src, HashSet<Integer> set){
        if(locked.containsKey(src))
            return true;
        
        if(set.contains(src))
            return false;
        
        set.add(src);
        for(int i : arr[src]){
            if(dfs(i,set))
                return true;
        }
        
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
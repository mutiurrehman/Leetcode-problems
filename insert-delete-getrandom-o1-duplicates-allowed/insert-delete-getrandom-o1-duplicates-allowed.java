class RandomizedCollection {

    HashMap<Integer, TreeSet<Integer>> map;
    ArrayList<Integer> arr;
    
    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            map.get(val).add(arr.size());
            arr.add(val);
            return false;
        }
        else{
            TreeSet<Integer> temp = new TreeSet<>();
            temp.add(arr.size());
            arr.add(val);
            map.put(val,temp);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int size = map.get(val).last();
        if(size<arr.size()-1){
            int temp = arr.get(arr.size()-1);
            arr.set(size, temp);
            int lst = map.get(temp).last();
            map.get(temp).remove(lst);
            map.get(temp).add(size);
        }
        
        arr.remove(arr.size()-1);
        if(map.get(val).size()==1){
            map.remove(val);
        }
        else{
            map.get(val).remove(size);
        }
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
         return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
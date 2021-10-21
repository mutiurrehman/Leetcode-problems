class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
      if(!map.containsKey(val))
          return false;
        
        int size = map.get(val);
        if(size<arr.size()-1){
            int temp =arr.get(arr.size()-1);
            arr.set(size, temp);
            map.put(temp,size);
        }
        
        map.remove(val);
        arr.remove(arr.size()-1);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
         return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
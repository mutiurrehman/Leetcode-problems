class StockPrice {

    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Set<Integer>> value;
    public StockPrice() {
        map = new TreeMap<>();
        value = new TreeMap<>();
        
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int old = map.get(timestamp);
            value.get(old).remove(timestamp);
            if(value.get(old).size()==0)
                value.remove(old);
        }
        
        map.put(timestamp , price);
        value.putIfAbsent(price, new HashSet<Integer>());
        value.get(price).add(timestamp);
    }
    
    public int current() {
        return  map.get(map.lastKey());
    }
    
    public int maximum() {
        return value.lastKey();
    }
    
    public int minimum() {
        return value.firstKey();
    }
}

/*
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
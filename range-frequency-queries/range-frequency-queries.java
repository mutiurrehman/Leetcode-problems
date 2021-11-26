class RangeFreqQuery {

    HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(arr[i], new TreeMap<>());
            map.get(arr[i]).put(i, map.get(arr[i]).size());
        }
    }

    public int query(int left, int right, int value) {
        if(!map.containsKey(value))
            return 0;
        
        TreeMap<Integer, Integer> tmp = map.get(value);
        Integer l = tmp.ceilingKey(left);
        Integer r = tmp.floorKey(right);
        if(l==null||r==null)
            return 0;
        
        return tmp.get(r)- tmp.get(l)+1;
    }
}
/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
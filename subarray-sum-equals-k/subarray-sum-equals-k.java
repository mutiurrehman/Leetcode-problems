class Solution {
    public int subarraySum(int[] arr, int k) {
        
     HashMap<Integer, Integer> map = new HashMap<>();
        int currSum=0,count=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum==k)
            count++;
            
            if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
               
            }
            if(map.containsKey(currSum)){
                 map.put(currSum,map.get(currSum)+1);
            }
            else{
                map.put(currSum,1);
            }
        }
        return count;
    }
}
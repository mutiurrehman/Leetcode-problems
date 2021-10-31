class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        if(map.size()<k)
            return "";
        
        int check=0;
        String ans="";
        for(String curr: map.keySet()){
            if(map.get(curr)==1){
                check++;
                if(check==k){
                    ans = curr;
                    break;
                }
            }
        }
        
        return ans;
    }
}
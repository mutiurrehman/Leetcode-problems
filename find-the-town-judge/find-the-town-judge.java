class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<trust.length;i++){
            map.put(trust[i][0]-1,trust[i][1]-1);
        }
        
        int[] arr = new int[n];
        for(int[] a: trust){
            arr[a[1]-1]++;
        }
        
        for(int i=0;i<n;i++){
            if(arr[i] == n-1  &&!map.containsKey(i)){
                return i+1;
            }
        }
        
        return -1;
    }
}
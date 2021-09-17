class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] ans = new int[1001];
        for(int i : nums1){
            ans[i]++; 
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int j : nums2){
            if(ans[j] > 0){
                list.add(j);
                ans[j]--;
            }
        }
        
        int[] finalAns = new int[list.size()];
        for(int i=0;i<list.size();i++){
            finalAns[i] = list.get(i);
        }
        
        return finalAns;
    }
}
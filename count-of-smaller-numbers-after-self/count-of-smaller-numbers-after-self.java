class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        count = new int[n];
        int[] originalIndex = new int[n];
        
        for(int i=0;i<n;i++){
            originalIndex[i] = i;
        }        
        
        sort(nums, originalIndex, 0, nums.length-1);
        
        for(int i=0;i<n;i++){
           res.add(count[i]);   
        }
        
        return res;
        
    }
    
    private void sort(int[] nums, int[] originalIndex, int l, int r){
        
        if(l<r){
            int mid = (l+r)/2;
            sort(nums, originalIndex, l, mid);
            sort(nums, originalIndex, mid+1,r);
            merge(nums, originalIndex,l, mid, r);
        }
    }
    
    private void merge(int[] nums, int[] originalIndex, int left, int mid , int right){
        int lArrSize = mid-left+1;
        int rArrSize = right - mid;
        
        int[] lArr = new int[lArrSize];
        int[] rArr = new int[rArrSize];
        
        for(int i=0;i<lArrSize;i++){
            lArr[i] = originalIndex[i+left]; 
        }
        
        for(int i=0;i<rArrSize;i++){
            rArr[i] = originalIndex[i+mid+1]; 
        }
        
        int i=0,j=0,k=left,rightCount=0;
        
        while(i<lArrSize && j<rArrSize){
            if(nums[lArr[i]]<=nums[rArr[j]]){
                originalIndex[k]=lArr[i];
                count[lArr[i]]+=rightCount;
                i++;
            }
            else{
                originalIndex[k]= rArr[j];
                rightCount++;
                j++;
            }
            k++;
        }
        
        while(i<lArrSize){
            originalIndex[k]=lArr[i];
            count[lArr[i]]+=rightCount;
            i++;
            k++;
        }
        
        while(j<rArrSize){
            originalIndex[k]=rArr[j];
            j++;
            k++;
        }
    }
}
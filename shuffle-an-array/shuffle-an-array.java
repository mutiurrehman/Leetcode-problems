class Solution {

    int[] arr;
    int[] ref;
    public Solution(int[] nums) {
        arr = nums.clone();
        ref = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
       return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i=1;i<ref.length;i++){
            int r = rand.nextInt(i+1);
            int temp = ref[r];
            ref[r] = ref[i];
            ref[i] = temp;
        }
        return ref;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
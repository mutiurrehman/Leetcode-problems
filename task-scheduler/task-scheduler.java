class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        
        int max =0,maxCount=0;
        
        for(char c : tasks){
            counts[c-'A']++;
            
            if(max == counts[c-'A']){
                maxCount++;
            }
            if(max<counts[c-'A']){
                max = counts[c-'A'];
                maxCount =1;
            }
        }
        
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max*maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return idles+tasks.length;
        
    }
}
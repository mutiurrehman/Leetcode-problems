class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        List<int[]> ques = new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            ques.add(intervals[i]);
        }
        
        for(int i=0;i<ques.size()-1;){
            int[] first = ques.get(i);
            int[] second = ques.get(i+1);
            
            if(first[1]<second[0]){
                i++;
            }
            else if(first[1]>=second[0]){
                ques.get(i)[0] = Math.min(first[0],second[0]);
                ques.get(i)[1] = Math.max(first[1],second[1]);
                ques.remove(i+1);
            }
        }
        
        int[][] res = new int[ques.size()][2];
        for(int i=0;i<ques.size();i++){
            res[i][0] = ques.get(i)[0];
            res[i][1] = ques.get(i)[1];
        }
        
        return res;
    }
}
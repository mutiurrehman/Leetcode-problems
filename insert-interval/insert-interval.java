class Solution {
    public int[][] insert(int[][] intervals, int[] ni) {
        
        List<int[]> ques = new ArrayList<>();
        
    
        for(int i=0;i<intervals.length;i++){
            ques.add(intervals[i]);
        }
        
        int i;
        for( i=0;i<ques.size();){
            int[] first = ques.get(i);
           
            if(first[1]<ni[0]){
                i++;
            }
            else if(first[0]>ni[1]){
                ques.add(i,ni);
                break;
            }
            else if(first[1]>=ni[0]){
                ni[0] = Math.min(first[0],ni[0]);
                ni[1] = Math.max(first[1],ni[1]);
                ques.remove(i);
                
            }
        }
        
        if(ques.size()==0)
                    ques.add(ni);
        if(i==ques.size())
        ques.add(ni);
        
        int[][] res = new int[ques.size()][2];
        for(int j=0;j<ques.size();j++){
            res[j][0] = ques.get(j)[0];
            res[j][1] = ques.get(j)[1];
        }
        
        return res;
        
    }
}
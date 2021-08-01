class Solution {
    public int majorityElement(int[] A) {
        int count1=0,count2=0;
        int first=-1,second=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]==first){
                count1++;
            }
            else if(A[i]==second){
                count2++;
            }
            else if(count1==0){
                count1++;
                first=A[i];
            }
            else if(count2==0){
                count2++;
                second=A[i];
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1=0;count2=0;
        for(int i=0;i<A.length;i++){
            if(first==A[i])
            count1++;
            if(second==A[i])
            count2++;
        }
        
        if(count1>A.length/2)
        return first;
        
        return second; 
    }
}
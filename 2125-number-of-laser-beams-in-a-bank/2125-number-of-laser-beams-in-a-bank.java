class Solution {
    public int numberOfBeams(String[] bank) {
        
        int ans=0;
        
        for(int i=0;i<bank.length;i++){
            boolean check = false;
            int index=-1;
            for(int j=i+1;j<bank.length;j++){
                String curr = bank[j];
                for(int k=0;k<curr.length();k++){
                    if(curr.charAt(k)=='1'){
                        check = true;
                        index = j;
                        break;
                    }
                }
                
                if(check)
                    break;

            }
            if(index==-1)
                break;
            int count=0, count2=0;
            for(int j=0;j<bank[index].length();j++){
                if(bank[index].charAt(j)=='1')
                    count++;
            }
            
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1')
                    count2++;
            }
            
            ans+=count*count2;
        }
        
        return ans;
    }
}
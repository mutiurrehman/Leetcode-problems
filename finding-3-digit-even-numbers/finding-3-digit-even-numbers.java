class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> ans = new HashSet<>();
        
        int n = digits.length;
        for(int i=0;i<n;i++){
            if(digits[i]%2!=0)
                continue;
            
            int cur = digits[i];
            int[] temp = new int[3];
            temp[2] = cur;
            
            for(int j=0;j<n;j++){
                if(j==i)
                    continue;
                for(int k=0;k<n;k++){
                    if(k==i || k==j)
                        continue;
                    
                    if(digits[j]!=0 && digits[k]!=0){
                        temp[0] = digits[j];
                        temp[1] = digits[k];
                        int num=temp[0]*100+temp[1]*10+temp[2];
                        ans.add(num);
                        temp[0] = digits[k];
                        temp[1] = digits[j];
                        num=temp[0]*100+temp[1]*10+temp[2];
                        ans.add(num);
                    }
                    else if(digits[j]!=0){
                        temp[0] = digits[j];
                        temp[1] = digits[k];
                        int num=temp[0]*100+temp[1]*10+temp[2];
                        ans.add(num);
                    }
                    else if(digits[k]!=0){
                        temp[0] = digits[k];
                        temp[1] = digits[j];
                        int num=temp[0]*100+temp[1]*10+temp[2];
                        ans.add(num);
                    }
                }
            }
        }
        
        int[] res = new int[ans.size()];
        int j=0;
        for(int i:ans){
            res[j++] =  i;
        }
        Arrays.sort(res);
        return res;
    }
}
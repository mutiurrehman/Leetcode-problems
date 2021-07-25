class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] str = num.toCharArray();
        int count=0;
        for(int i=0;i<str.length;i++){
            if(change[str[i]-'0']>(str[i]-'0')){
                str[i]=(char)(change[str[i]-'0']+'0');
                count++;
            }
            else if(change[str[i]-'0']==(str[i]-'0')){
                continue;
            }
            else{
                if(count>0)
                    break;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length;i++)
            ans.append(str[i]);
        
        return ans.toString();
    }
}
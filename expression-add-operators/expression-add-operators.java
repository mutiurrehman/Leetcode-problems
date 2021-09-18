class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(ans,"",num,target,0,0,0);
        return ans;
    }
    
    public void helper(List<String> ans, String path, String num, int target, int pos, long eval, long multed){
        if(pos==num.length()){
            if(eval == target){
                ans.add(path);
            }
            return;
        }
        
        for(int i=pos;i<num.length();i++){
            if(i!=pos && num.charAt(pos)=='0'){
                break;
            }
            
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos==0){
                helper(ans,path+cur,num,target,i+1,cur,cur);
            } else{
                helper(ans,path+"+"+cur,num,target,i+1, eval+cur, cur);
                helper(ans,path+"-"+cur,num,target,i+1, eval-cur, -cur);
                helper(ans,path+"*"+cur,num,target,i+1, eval-multed +multed*cur, multed*cur);
            }
        }
    }
}
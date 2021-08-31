class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        List<String> res = helper(n);
        for(int i=0;i<res.size();i++){
            ans.add(Integer.parseInt(res.get(i),2));
        }
        
        return ans;
        
    }
    
    public List<String> helper(int n){
        if(n==1){
            List<String> br = new ArrayList<>();
            br.add("0");
            br.add("1");
            return br;
        }
        
        List<String> rres = helper(n-1);
        
        List<String> mres = new ArrayList<>(); 
         for(int i=0;i<rres.size();i++){
            mres.add("0"+rres.get(i));
        }
        
        for(int i=rres.size()-1;i>=0;i--){
            mres.add("1"+rres.get(i));
        }
        
        return mres;
    }
    
}
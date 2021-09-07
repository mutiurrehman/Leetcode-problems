class Solution {
    public String fractionToDecimal(int a1, int b1) {
        
        if(a1==0)
        return "0";
        if(b1==0)
        return "";
        
        StringBuilder ans = new StringBuilder();
        long a = (long)a1,b=(long)b1;
        if((a<0 && b>0) || (a>0 && b<0))
        ans.append("-");
        
        a = Math.abs(a);
        b = Math.abs(b);
        long q = (a/b);
        long rem = a%b;
        ans.append(q);
        if(rem==0){
            return ans.toString();
        }
        
       ans.append(".");
       HashMap<Long,Integer> map = new HashMap<>();
       while(rem!=0){
           if(map.containsKey(rem)){
               int pos = map.get(rem);
               ans.insert(pos,"(");
               ans.append(")");
               break;
           }
           map.put(rem,ans.length());
           rem*=10;
           q = rem/b;
           rem=rem%b;
           ans.append(q);
       }
       
        return ans.toString();
    
    }
}

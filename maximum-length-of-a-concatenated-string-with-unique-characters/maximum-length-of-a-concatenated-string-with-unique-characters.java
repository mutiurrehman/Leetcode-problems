import java.math.BigInteger;
class Solution {
    public int maxLength(List<String> lst) {
     
        String[] arr = new String[lst.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = lst.get(i);
        }
        subs(arr.length, arr);
        return max;
    }
    
    int max = 0;
    public void subs(int n, String[] arr) {
        int opsize = (int)Math.pow(2, n);
      
        for (int counter = 1; counter < opsize; counter++) {
            String curr ="";
            for (int j = 0; j < n; j++) {
                if (BigInteger.valueOf(counter).testBit(j)){
                     curr+=arr[j];
                    if(isUnique(curr)){
                        max = Math.max(max, curr.length());
                    }
                }
            }
        }
    }
    
    public boolean isUnique(String str){
        char[] map = new char[26];
        
        for(char cc: str.toCharArray()){
            if(map[cc-'a']==1)
                return false;
            map[cc-'a']++;
        }
        
        return true;
    }
}
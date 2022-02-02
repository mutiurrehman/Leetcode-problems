class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = p.length();
        
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        String toCheck = String.valueOf(arr);
        HashSet<String> set = new HashSet<>();
        set.add(toCheck);
        for(int i=0;i<=s.length()-n;i++){
            
            String sb =  s.substring(i,i+n);
            char[] temp = sb.toCharArray();
            Arrays.sort(temp);
            
            String curr = String.valueOf(temp);
            if(set.contains(curr))
                ans.add(i);
        }
        
        return ans;
    }
}
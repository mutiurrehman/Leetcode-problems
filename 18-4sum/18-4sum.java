class Solution {
    public List<List<Integer>> fourSum(int[] a, int b) {
    List<List<Integer>> ans = new ArrayList<>();
        
        HashSet<List<Integer>> vis =  new HashSet<>();
        Arrays.sort(a);
        int n = a.length;
        for(int i=0;i<n;i++){
           
            int f = a[i];
            for(int j = i+1;j<n;j++){
                int s = a[j];
                 HashSet<Integer> set = new HashSet<>();
                 for(int k=j+1;k<n;k++){
                    int t = a[k];
                    if(set.contains(b - (f+s+t))){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(f);
                        temp.add(s);
                        temp.add(t);
                        temp.add(b - (f + s + t));
                        Collections.sort(temp);
                        if(!vis.contains(temp)){
                        ans.add(temp);
                        vis.add(temp);
                        }
                    }
                    else
                    set.add(t);
                }
            }
        }
        
        return ans;
            
    }
}
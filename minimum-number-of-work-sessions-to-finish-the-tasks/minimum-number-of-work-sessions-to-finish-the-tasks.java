class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        return helper(tasks, sessionTime, 0, tasks.length);
    }
    
    ArrayList<Integer> sessions = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    
    public String encode(int pos){
         ArrayList<Integer> copy = new ArrayList<>(sessions);
        String s="";
        s+=pos+"$";
        Collections.sort(copy);
        
        for(int i=0;i<copy.size();i++){
            s+=copy.get(i)+"$";
        }
        
        return s;
    }
    
    public int helper(int[] tasks, int sessionTime, int pos, int n){
        if(pos>=n)
            return 0;
        
        String encoded = encode(pos);
        if(map.containsKey(encoded))
            return map.get(encoded);
        
        sessions.add(tasks[pos]);
        int ans = 1 + helper(tasks,sessionTime,pos+1,n);
        sessions.remove(sessions.size()-1);
        
        for(int i=0;i<sessions.size();i++){
            if(sessions.get(i)+tasks[pos]<=sessionTime){
                sessions.set(i,tasks[pos]+sessions.get(i));
                ans =Math.min(ans, helper(tasks,sessionTime,pos+1,n));
                sessions.set(i,sessions.get(i)-tasks[pos]);
            }
        }
        
        map.put(encoded,ans);
        return ans;
    }
    
    
}
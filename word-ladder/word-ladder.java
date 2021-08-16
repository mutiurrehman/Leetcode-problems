class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
          if(!wordList.contains(e))
              return 0;
        
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(b);
        int level=0;
        while(!q.isEmpty()){
            level++;
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr = q.remove();
                char[] c1 = curr.toCharArray();
                for(int j=0;j<c1.length;j++){
                    char[] temp = new char[c1.length];
                    for(int k=0;k<temp.length;k++){
                        temp[k] = c1[k];
                    }
                    
                    for(char k='a';k<='z';k++){
                        temp[j]=k;
                        
                        if(curr.equals(String.valueOf(temp)))
                            continue;
                        
                        if(e.equals(String.valueOf(temp)))
                            return level+1;
                        
                        if(set.contains(String.valueOf(temp))){
                            q.add(String.valueOf(temp));
                            set.remove(String.valueOf(temp));
                        }
                    }
                }
            }
            
        }
        
        return 0;
    }
}
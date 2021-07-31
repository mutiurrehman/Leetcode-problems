class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
          if(!wordList.contains(e))
              return 0;
        
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(b);
        int depth=0;
        while(!q.isEmpty()){
            depth+=1;
            int size=q.size();
            
            while(size-->0){
                String curr = q.remove();
                char[] ch = curr.toCharArray();
                
                for(int i=0;i<ch.length;i++){
                    char[] temp = new char[ch.length];
                    for(int j=0;j<ch.length;j++){
                        temp[j]=ch[j];
                    }
                    
                    for(char c='a';c<='z';c++){
                        temp[i]=c;
                        if(curr.equals(String.valueOf(temp)))
                            continue;
                        
                        if(e.equals(String.valueOf(temp)))
                            return depth+1;
                        
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
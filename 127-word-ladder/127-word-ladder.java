class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         if(!wordList.contains(endWord))
              return 0;
        HashSet<String> set = new HashSet<>(wordList);
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level =0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            
            for(int i=0;i<size;i++){
                String curr = q.poll();
                char[] c1 = curr.toCharArray();
                for(int j=0;j<c1.length;j++){
                    char[] temp = new char[c1.length];
                    for(int k=0;k<c1.length;k++){
                        temp[k] = c1[k];
                    }
                    
                    for(char c = 'a';c<='z';c++){
                        temp[j] = c;
                        String check = String.valueOf(temp);
                        if(curr.equals(check))
                            continue;
                        
                        if(check.equals(endWord)){
                            return level+1;
                        }
                        
                        if(set.contains(check)){
                            set.remove(check);
                            q.add(check);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
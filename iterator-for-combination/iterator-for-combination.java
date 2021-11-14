class CombinationIterator {

    List<String> combs = new ArrayList<>();
    int n;
    int i=0;
    public CombinationIterator(String s, int n) {
        this.n = n;
        helper(s,new StringBuilder(),0);
        Collections.sort(combs);
    }
    
    public String next() {
        return combs.get(i++);
    }
    
    public boolean hasNext() {
        if(i>=combs.size())
            return false;
        
        return true;
    }
    
    public void helper(String s, StringBuilder temp, int start){
        if(temp.length()==n)
            combs.add(temp.toString());
        
        for(int i=start;i<s.length();i++){
            char cc = s.charAt(i);
            temp.append(cc);
            helper(s,temp, i+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
class SORTracker {

    TreeSet<Pair> set = new TreeSet<>();
    Pair curr = null;
    
    public void add(String name, int score) {
        Pair pair = new Pair(name, score);
        
        set.add(pair);
        
        if(curr!=null && pair.compareTo(curr)<0){
            curr = set.lower(curr);
        }
    }
    
    public String get() {
        if(curr==null){
            curr = set.first();
        }
        else{
            curr = set.higher(curr);
        }
        
        return curr.str;
    }
    
    static class Pair implements Comparable<Pair>{
        String str;
        int score;
        
        Pair(String str, int score){
            this.str = str;
            this.score = score;
        }
        
        public int compareTo(Pair o){
            
            return score==o.score ? str.compareTo(o.str) : -Integer.compare(score, o.score);
        }
        
        public String toString(){
            return str+" "+ score+" ";
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
class Trie {

    ArrayList<String> trie;
    /** Initialize your data structure here. */
    public Trie() {
        trie = new ArrayList<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        trie.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        for(int i=0;i<trie.size();i++){
            if(word.equals(trie.get(i)))
                return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         for(int i=0;i<trie.size();i++){
            if(trie.get(i).startsWith(prefix))
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
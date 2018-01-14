    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Trie dict = new Trie();
        
        for(String word : wordDict) dict.insert(word);
        
        return find(s, 0, dict, map);
    }
    
    private boolean find(String s, int start, Trie dict, Map<String, Boolean> map){
        if(start == s.length()){
            if(s.length() > 1) map.put(s, true);
            return true;
        }
        
        for(int i=start; i<s.length(); i++){
            if(dict.search(s.substring(start, i+1))
                           && (map.containsKey(s.substring(i+1)) || find(s, i+1, dict, map) )
              ) 
                return true;
        }
        return false;
    }

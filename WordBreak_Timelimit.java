class Solution{
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie dict = new Trie();
        for(String word : wordDict) dict.insert(word);
        
        return find(s, 0, dict);
    }
    
    private boolean find(String s, int start, Trie dict){
        if(start == s.length()){
            if(s.length() > 1) map.put(s, true);
            return true;
        }
        
        //Brute force recursion => TimeLimit exceeded
        for(int i=start; i<s.length(); i++){
            if(dict.search(s.substring(start, i+1)) && find(s, i+1, dict, map )
              ) 
                return true;
        }
        return false;
    }
}

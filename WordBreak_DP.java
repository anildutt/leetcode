package leetcode;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie dict = new Trie();
        
        for(String word : wordDict) dict.insert(word);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        //dp[i] = true => s.substring(0, i), i.e. s[0..i-1] is possible
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.search(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        //final answer dp[N] = dp[0.. N-1]. 
        return dp[s.length()];
    }
}

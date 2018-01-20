class Solution {
    List<String> result ; 
    Set<String> dict;
    public String findLongestWord(String s, List<String> d) {
        //approach 1 - BFS => if Dictionary is large
        result = new ArrayList<String>();
        dict = new HashSet<String>(d);
        String ans =  BFS(s);
        
        //approach 2 - If dictionary is small [Accepted]
        String ans =  findLongestWordUtil(s, d);
        return ans;
    }
     
    private String findLongestWordUtil(String s, List<String> d){
        Collections.sort(d, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s1.length() != s2.length()) ? s2.length()-s1.length() : 
                    s1.compareTo(s2);
            }
        });
        
        for(String str : d)
            if(isSubsequence(s, str)) 
                return str;
        return "";
    }
    
    private boolean isSubsequence(String str, String word){
        int i = 0, j = 0;
        // if(word.length() < str.length()) return false;
        if(word.length() == str.length()) return word.equals(str);
        while(i<word.length() && j<str.length()){
            if(word.charAt(i) == str.charAt(j)){
                i++; 
                j++;
            }else j++;
        }
        return i == word.length();
    }
    
    private String BFS(String s){
        
        Queue<String> Q = new LinkedList<String>();
        Q.add(s);
        
        while(Q.isEmpty() == false){
            int sz = Q.size();
            for(int count=0; count<sz; count++){
                String str = Q.remove();

                if(dict.contains(str))
                    result.add(str);
                else{
                    for(int i=0; i<str.length(); i++){
                        String sb = (i==0 ? "" : str.substring(0, i)) 
                            + ( (i < str.length()-1) ? str.substring(i+1) : "" ); //delete 1 char
                        Q.add(sb);
                    }
                }
            }
            
            if(result.size() > 0){
                Q.clear();
                Collections.sort(result);
                return result.get(0); 
            }
        }
     
        return "";
    }
}

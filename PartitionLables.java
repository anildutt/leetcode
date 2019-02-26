package leetcode;

class Solution {
    int freq[] = new int[26];
    public List<Integer> partitionLabels(String S) {
        computeFreq(S); //preprocess
        
        if(S.length() == 0) return Collections.emptyList();
        
        Map<Character, Integer> curMap = new HashMap<Character, Integer>();
        List<Integer> groups = new ArrayList<Integer>();
        int i = 0, start = 0;
        
        curMap.put(S.charAt(0), freq[S.charAt(0)-'a']); //init with first char frequency
        
        //
        while(i < S.length()){
            
            if(curMap.size() == 0){ //its a char from new group
                groups.add(i - start);
                start = i;
                curMap.put(S.charAt(i), freq[S.charAt(i)-'a']);
            }

            //if visited char, update
            if(curMap.containsKey(S.charAt(i))){
                if(curMap.get(S.charAt(i)) == 1){
                    curMap.remove(S.charAt(i));
                }
                else
                    curMap.put(S.charAt(i), curMap.get(S.charAt(i)) - 1);
            }else{ //new char, add
                if(freq[S.charAt(i)-'a'] > 1)
                    curMap.put(S.charAt(i), freq[S.charAt(i)-'a'] - 1);
            }
            
            i++;
        }
        
        groups.add(i - start);
        
        return groups;
    }
    
    private void computeFreq(String S){
        for(int i=0; i<S.length(); i++)
            freq[S.charAt(i) - 'a'] ++;
    }
}

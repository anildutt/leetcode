class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        partition(s, 0, new ArrayList<String>(), result);
        return result;
    }
    
    private void partition(String s, int start, 
                           List<String> curSol, 
                           List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<String>(curSol));
            return;
        }
        
        for(int i=start; i<s.length(); i++){
            if(isPalind(s.substring(start, i+1))){
                curSol.add(s.substring(start, i+1));
                partition(s, i + 1, curSol, result);
                curSol.remove(curSol.size() - 1);
            }
        }
    }
    
    private boolean isPalind(String s){
        if(s.length() == 1) return true;
        if(s.length() == 2) return s.charAt(0) == s.charAt(1);
        for(int i=0; i<s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return true;
    }
}

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> freq = new HashMap<String, Integer>();
        
        for(String domStr : cpdomains){
            String[] freqDom = domStr.split("\\s+");
            
            int f = Integer.valueOf(freqDom[0]);
            String[] tokens = freqDom[1].split("[.]");
            
            String suffix = new String("");
            for(int i=tokens.length-1; i>=0; i--){
                suffix = (suffix.equals("")) ? tokens[i] : tokens[i] + "." + suffix;
                freq.put(suffix, freq.getOrDefault(suffix, 0) + f);
            }
        }
        List<String> result = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : freq.entrySet())
            result.add(entry.getValue() + " " + entry.getKey());
        return result;
    }
}

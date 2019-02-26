package leetcode;

class Solution {
    public String frequencySort(String s) {
        //Build Frequency Map: Ch -> Frequency
        Map<Character, Integer> freqMap = new HashMap<Character,  Integer>();
        for(int i=0; i<s.length(); i++){
            if(freqMap.containsKey(s.charAt(i)))
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))  + 1 );
            else freqMap.put(s.charAt(i), 1);
        }
        
        //Build map of Frquency -> List<Character>
        Map<Integer, List<Character>> map = new TreeMap<Integer, List<Character>>();
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            Character ch = entry.getKey();
            Integer freq = entry.getValue();
            
            if(map.containsKey(freq)){
                List<Character> list = map.get(freq);
                list.add(ch);
                map.put(freq, list);
            }else{
                List<Character> list = new ArrayList<Character>();
                list.add(ch);
                map.put(freq, list);
            }
        }
        
        //reverse order by frequency
        map = ((TreeMap<Integer, List<Character>>)map).descendingMap();
        
        //Read from max freq to min freq & append each char freq times
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, List<Character>> entry : map.entrySet()){
            Integer freq = entry.getKey();
            List<Character> list = entry.getValue();
            
            for(int i=0; i<list.size(); i++){
                for(int j = 0; j<freq; j++)
                    sb.append(list.get(i));
            }
        }
        
        //return the string
        return sb.toString();
    }
}

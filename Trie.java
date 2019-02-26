package leetcode;

class Trie {
    
    TrieNode root;
    class TrieNode{
        char ch;
        Map<Character, TrieNode> children;
        boolean isLeaf;
        
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
        }
        public TrieNode(char c){
            ch = c;
            children = new HashMap<Character, TrieNode>();
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char curc = word.charAt(i);
            if(cur.children.containsKey(curc))
                cur = cur.children.get(curc);
            else{
                TrieNode child =  new TrieNode(curc);
                cur.children.put(curc, child);
                cur = child;
            }
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int i = 0;
        TrieNode cur = root;
        
        while(i<word.length()){
            if(cur.children.containsKey(word.charAt(i))){
                cur = cur.children.get(word.charAt(i));
            }else
                return false;
            i++;
        }
        
        return cur.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        int i = 0;
        TrieNode cur = root;
        while(i<word.length()){
            if(cur.children.containsKey(word.charAt(i))){
                cur = cur.children.get(word.charAt(i));
            }else
                return false;
            i++;
        }
        
        return true;
    }
}

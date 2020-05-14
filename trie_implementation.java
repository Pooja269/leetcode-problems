/*Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
*/
class TrieNode{
    TrieNode[] children;
    boolean isleaf;
    public TrieNode(){
        this.children=new TrieNode[26];
    }
}
class Trie {
    
    /** Initialize your data structure here. */
    public TrieNode root;
    public Trie() {
        root=new TrieNode();
        root.isleaf=false;
        for(int i=0;i<26;i++){
            root.children[i]=null;
        }
    }
    //static Trie root;
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
                //System.out.println(node.children);
            }
            node=node.children[index];
        }
        node.isleaf=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.children[index]!=null){
                node=node.children[index];
            }
            else{
                return false;
            }
            if(node==root){
                return false;
            }
            
        }
        if(node.isleaf){
                return true;
        }
        return false;    
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(node.children[index]!=null){
                node=node.children[index];
            }
            else{
                return false;
            }
            if(node==root){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

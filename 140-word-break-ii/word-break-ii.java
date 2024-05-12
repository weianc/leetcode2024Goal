class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 1. Add all word into trie
        Trie trie = new Trie();
        for(String w : wordDict){
            trie.insert(w);
        }
        List<String> res = new ArrayList<>();
        // 2. call DFS to find answer for wordBreak
        DFS(s, 0, "", res, trie);
        return res;
    }

    private void DFS(String s, int startIdx, String accStr, List<String> res, Trie trie){
        if(startIdx == s.length()){
            // 表示已經到達given string的終點
            // 將當前sb加入res
            res.add(accStr);
            return;
        }

        for(int i = startIdx; i < s.length(); i++){
            // include i..
            String curr = s.substring(startIdx, i+1);
            if(trie.isPrefixWord(curr)){
                if(accStr.length() == 0){
                    // find s[i+1, s.length()-1] is breakable? 
                    DFS(s, i+1, accStr + curr, res, trie);
                }
                else {
                    DFS(s, i+1, accStr + " " + curr , res, trie);
                }                
            }
        }
    }

    class Trie 
    {
        class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
                isWord = false;
                for (int i = 0; i < 26; i++) {
                    children[i] = null;
                }
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] array = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                // 当前孩子是否存在
                if (cur.children[array[i] - 'a'] == null) {
                    cur.children[array[i] - 'a'] = new TrieNode();
                }
                cur = cur.children[array[i] - 'a'];
            }
            // 当前节点代表结束
            cur.isWord = true;
        }

        public boolean isPrefixWord(String prefix) {
            char[] array = prefix.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                if (cur.children[array[i] - 'a'] == null) {
                    return false;
                }
                cur = cur.children[array[i] - 'a'];
            }
            return cur.isWord;
        }
    }
}
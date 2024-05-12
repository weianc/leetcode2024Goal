class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 1. Add all word into trie
        Trie trie = new Trie();
        for(String w : wordDict){
            trie.insert(w);
        }
        List<String> res = new ArrayList<>();
        // Using HashMap to store intermediate results
        Map<Integer, List<String>> memo = new HashMap<>();
        // 2. call DFS to find answer for wordBreak
        return DFS(s, 0, trie, memo);
    }

    private List<String> DFS(String s, int startIdx, Trie trie, Map<Integer, List<String>> memo){
        if (memo.containsKey(startIdx)) {
            return memo.get(startIdx);
        }

        List<String> res = new ArrayList<>();

        // Base case
        if(startIdx == s.length()){
            // 表示已經到達given string的終點
            // 將當前sb加入res
            res.add("");
            return res;
        }

        for(int i = startIdx; i < s.length(); i++){
            // include i..
            String curr = s.substring(startIdx, i+1);
            if(trie.isPrefixWord(curr)){
                List<String> sublist = DFS(s, i+1, trie, memo);
                for (String sub : sublist) {
                    res.add(curr + (sub.isEmpty() ? "" : " " + sub));
                }             
            }
        }

        // Save the result in the memo map
        memo.put(startIdx, res);
        return res;
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
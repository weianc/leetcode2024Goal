class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return traverse(s, 0, wordDict, new HashMap<>());
    }

    // 站在回溯树的每个节点上，看看哪个单词能够匹配 s[i..]，从而判断应该往哪条树枝上走
    private boolean traverse(String s, int i, List<String> wordDict, Map<Integer, Boolean> memo){
        // 1. 遞迴的出口
        if(i == s.length()) return true;

        // 2. check memo table
        if(memo.containsKey(i)){
            return memo.get(i);
        }

        boolean isBreakable = false;
        for(String w : wordDict){
            int len = w.length();
            // match with s[i, i+len-1]
            // need to add boundary
            if(i+len > s.length()) continue;
            String substring = s.substring(i, i+len);
            if(substring.equals(w)){
                // start from index i+len to match with next word
                if(traverse(s, i+len, wordDict, memo)){
                    isBreakable = true;
                }
            }
        }

        // before return, save isBreakable to memo
        memo.put(i, isBreakable);
        return isBreakable;
    } 
}


class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length(); // 每個char都要用一張貼紙
        Map<String, Map<Character, Integer>> stickerCharCountMap = new HashMap<>();
        for(String s : stickers){
            Map<Character, Integer> charCount = new HashMap<>();
            for(char c : s.toCharArray()){
                //char c = s.charAt(i);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
            stickerCharCountMap.put(s, charCount);
        }

        //Map<String, Integer> memo = new HashMap<>();
        int res = DFS(stickers, target, stickerCharCountMap, new HashMap<>(), n);
        return res > target.length() ? -1 : res;
    }

    private int DFS(String[] stickers, String targetStr,
        Map<String, Map<Character, Integer>> stickerCharCountMap,
        Map<String, Integer> memo,
        int n){
        // 遍歷貼紙查看是否有第一個char match target String
        // 1. 有match current first char: 遍歷當前貼紙，並且用盡所有可以用的單字
        // 2. 略過

        // 2. 遞迴的出口
        if(targetStr.length() == 0) return 0;

        // 1. check memo table
        if(memo.containsKey(targetStr)){
            return memo.get(targetStr);
        }

        int res = n + 1;
        // (1)with, (2)example, (3)science
        for(String s : stickers){
            Map<Character, Integer> tmpCharCount = new HashMap<>(stickerCharCountMap.get(s));
            char firstChar = targetStr.charAt(0);
            if(!tmpCharCount.containsKey(firstChar)) continue;
            // iterate through current String and remove match word in sticker s
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < targetStr.length(); i++){
                char c = targetStr.charAt(i);
                if(tmpCharCount.containsKey(c) && tmpCharCount.get(c) > 0){
                    tmpCharCount.put(c, tmpCharCount.get(c) - 1);
                    //currentStr = currentStr.substring(0, i) + currentStr.substring(i+1);
                }
                else {
                    sb.append(c);
                }
            }
            // last step: if currentStr is modified,
            // return res with the following dfs(remainStr)
            // then update memo table
            // 1 more sticker was used.
            // currentStr: ehat, targetStr: thehat
            if(sb.length() != targetStr.length()){
                res = Math.min(res, 1 + DFS(stickers, sb.toString(), stickerCharCountMap, memo, n));
                // update memo table
                memo.put(targetStr, res);
            }
        }
        return res;
    }
}
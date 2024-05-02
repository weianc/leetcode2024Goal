class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int globalMin = Integer.MAX_VALUE;
        String minWindow = "";
        int totalUniqueCharCount = charMap.size();
        int count = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            // 1. enlarge  window
            char charS = s.charAt(right);
            // check current char totalUniqueCharCount
            if(charMap.containsKey(charS)){
                window.put(charS, window.getOrDefault(charS, 0) + 1);
                if(window.get(charS).equals(charMap.get(charS))){ // match condition
                    count++;
                }
            }

            // 2. shrink window if needed
            // 判断左侧窗口是否要收缩
            while(count == totalUniqueCharCount){
                if(globalMin > right - left + 1){
                    globalMin = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                }
                
                // 移出的字符d
                char d = s.charAt(left);
                if(charMap.containsKey(d)){
                    if(window.get(d).equals(charMap.get(d))){
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                    // if(window.get(d) == 0){
                    //     window.remove(d);
                    // }
                }
                // left往前
                left++;
            }
            right++;
        }
        return minWindow;
    }
}
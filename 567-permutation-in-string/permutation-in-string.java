class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 1. Initialize all char mapping which are needed
        Map<Character, Integer> need = new HashMap<>();
        // 2. current char mapping for window
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int valid = 0;

        while(l <= r && r < s2.length()){
            char c = s2.charAt(r);
            r++;
            // 更新window資訊
            
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // check if window should shrink
            while(r - l == s1.length()){
                // check if current window string match requirement
                if(valid == need.size()){
                    return true;
                }
                // remove s[left] from window
                char d = s2.charAt(l);
                l++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
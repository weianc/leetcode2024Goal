class Solution {
    public int maxDepth(String s) {
        int left = 0;
        int globalMax = 0;
        boolean isEmptyStr = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                left++;
            }
            else if (c == ')'){
                left--;
            }
            globalMax = Math.max(globalMax, left);
        }

        return globalMax;
    }
}
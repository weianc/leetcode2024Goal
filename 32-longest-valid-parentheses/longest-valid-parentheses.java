class Solution {
    public int longestValidParentheses(String s) {
        // dp function definition: dp[i]是s[i-1]為結尾的最長合法括號
        int[] dp = new int[s.length()+1]; 
        int maxLength = 0;
        // 1. set initial value
        dp[0] = 0;   
        // stack儲存左括號的index
        Stack<Integer> stk = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stk.push(i);
            }
            else if (c == ')'){
                // no left parenthesis left to be pair
                if(stk.isEmpty()){
                    // s[0..i]的最長合法括號長度是0
                    dp[i+1] = 0;
                }
                else {
                    // 棧頂彈出最靠近當前尚未被匹配的左括號
                    int leftIndex = stk.pop();
                    int curLVP = i - leftIndex + 1; // 當前右括號和棧頂左括號長度
                    dp[i+1] = dp[leftIndex] + curLVP;
                }
            }
        }

        // iterate through dp array for maximum LVP
        for(int i = 0; i < dp.length; i++){
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
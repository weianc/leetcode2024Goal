class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> stk = new Stack();
        int missingLeft = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stk.push(i);
            }
            else {
                if(stk.isEmpty()){
                    missingLeft++;
                }
                else {
                    stk.pop();
                }
            }
        }
        // missingLeft: 不夠的左括號
        // stk.size(): 剩餘的右括號
        return missingLeft + stk.size();
    }
}
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> stk = new Stack();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stk.push(i);
            }
            else {
                if(stk.isEmpty()){
                    count++;
                }
                else {
                    stk.pop();
                }
            }
        }
        return count + stk.size();
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        // 1. if s == number, push to stk
        // 2. if s == operator, pop top 2 number from the stk and calculate
        // then push back to stk
        Stack<Integer> stk = new Stack();
        for(String t : tokens){
            if(t.equals("+")){
                if(stk.size() < 2){
                    break;
                }
                else {
                    int second = stk.pop();
                    int first = stk.pop();
                    stk.push(first + second);
                }
            }
            else if (t.equals("-")){
                if(stk.size() < 2){
                    break;
                }
                else {
                    int second = stk.pop();
                    int first = stk.pop();
                    stk.push(first - second);
                }
            }
            else if (t.equals("*")){
                if(stk.size() < 2){
                    break;
                }
                else {
                    int second = stk.pop();
                    int first = stk.pop();
                    stk.push(first * second);
                }
            }
            else if (t.equals("/")){
                if(stk.size() < 2){
                    break;
                }
                else {
                    int second = stk.pop();
                    int first = stk.pop();
                    stk.push(first / second);
                }
            }
            else {
                int num = Integer.parseInt(t);
                stk.push(num);
            }
        }
        
        if(stk.empty()){
            return 0;
        }
        return stk.peek();
    }
}
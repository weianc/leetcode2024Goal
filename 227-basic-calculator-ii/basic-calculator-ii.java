

import static java.lang.Math.log;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack();
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');
        char sign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                // add to last number if there's one
                num = num * 10 + c - '0';
            }
            // need to consider last char in string last char is isDigit
            // or this will not be added into stack
            if(set.contains(c) || i == s.length() - 1) // sign
            {
                int pre;
                if(sign == '+'){
                    stk.push(num);
                }
                else if (sign == '-'){
                    stk.push(-num);
                }
                else if (sign == '*'){
                    pre = stk.pop();
                    stk.push(pre * num);
                }
                else if (sign == '/'){
                    pre = stk.pop();
                    stk.push(pre / num);
                }
                // reset num and sign
                num = 0;
                sign = c;
            }
        }
        int res = 0;
        // calculate total
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return res;
    }
}
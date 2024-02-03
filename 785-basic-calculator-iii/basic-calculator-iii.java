class Solution {
    public int calculate(String s) {
        Deque<Character> strQueue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            strQueue.add(c);
        }
        return helper(strQueue);
    }

    private int helper(Deque<Character> s)
    {
        int num = 0;
        char sign = '+';
        
        Stack<Integer> stk = new Stack();
        while(!s.isEmpty()){
            char c = s.poll();
            if(c == '('){
                // recursion start
                num = helper(s);
            }
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            // c is the last digit. Should add number to stk
            if (!Character.isDigit(c) || s.isEmpty()){
                if(sign == '+'){
                    stk.push(num);
                }
                else if (sign == '-'){
                    stk.push(-num);
                }
                else if (sign == '*'){
                    // operate stk peek and num
                    int prev = stk.pop();
                    stk.push(prev * num);
                }
                else if (sign == '/'){
                    int prev = stk.pop();
                    stk.push(prev / num);
                }

                // reset sign with latest char
                sign = c;
                num = 0;
            }
            // 遇到右括号返回递归结果
            if(c == ')'){
                // 需要跳出loop計算當前在stack裡的總和
                // 也就是括號內所有字串的計算總和
                // 直接回傳nums只計算到當前number的值
                break;
            }
        }
        // add all the numbers in stk together
        for(int i : stk){
            num += i;
        }
        return num;
    }
}
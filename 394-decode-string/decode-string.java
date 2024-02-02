class Solution {
    private String repeatStringByTimes(String s, int num)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++){
            sb.append(s);
        }
        return sb.toString();
    }
    public String decodeString(String s) {
        Stack<Object> stk = new Stack();
        int prevNum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                int cur = c - '0';
                prevNum = prevNum * 10 + cur;
            }
            else if(c == '[')
            {
                if(prevNum != 0){
                    stk.push(prevNum);
                }
                prevNum = 0;
            }
            else if(c == ']')
            {
                // pop all the object until empty or number
                String next = "";
                Integer repeatTimes = 0;
                String combinedStr = "";
                while(!stk.isEmpty())
                {
                    Object obj = stk.pop();
                    if(obj instanceof Integer)
                    {
                        repeatTimes = (Integer) obj;
                        combinedStr = repeatStringByTimes(next, repeatTimes) + combinedStr;
                        stk.push(combinedStr);
                        break;
                    }
                    else 
                    {
                        next = obj.toString() + next;
                    }
                }
            }
            else {
                stk.push(c);
            }
        }

        // pop out all the element
        String ans = "";
        Integer repeatTimes = 0;
        String repeatStr = "";
        while(!stk.isEmpty())
        {
            Object obj = stk.pop();
            if(obj instanceof Integer)
            {
                repeatTimes = (Integer) obj;
            }
            else 
            {
                repeatStr = obj.toString() + repeatStr;
            }

            if (repeatTimes != 0){
                ans = repeatStringByTimes(repeatStr, repeatTimes) + ans;
                // reset repeatTimes and repeatStr
                repeatStr = "";
                repeatTimes = 0;
            }
        }
        return ans + repeatStr;
    }
}
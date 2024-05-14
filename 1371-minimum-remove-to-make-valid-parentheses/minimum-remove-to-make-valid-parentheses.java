class Solution {
    public String minRemoveToMakeValid(String s) {
        // leet(t(c)o)de)
        Stack<Integer> stk = new Stack();
        int j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(c == '('){
                stk.push(j);
            }
            else if (c == ')'){
                if(stk.isEmpty()){
                    // remove current position from s directly
                    s = s.substring(0, j) + s.substring(j+1, s.length());
                    continue;
                }
                else {
                    stk.pop();
                }
            }
            j++;
        }

        String res = "";
        int i = s.length();
        while(!stk.isEmpty()){
            int index = stk.pop();
            String substring = s.substring(index+1, i); // do not include i
            i = index;
            res = substring + res;
        }

        res = s.substring(0, i) + res;

        return res;
    }
}
class Solution {
    public String simplifyPath(String path) {
        String ans = "";
        Stack<String> stk = new Stack();
        String[] arr = path.split("/");
        for(String s : arr){
            // 1. s == "..", should pop element from stk 
            // because we want to go back to previous level of directory
            if(s.equals("..")){
                if(!stk.empty()){
                    stk.pop();
                }
            }
            // 2. s == "." or s is empty
            // skip this iteration 
            // because . and empty should not present in simplify path
            else if (s.equals(".") || s.isEmpty()){
                continue;
            }
            else {
                stk.push(s);
            }
        }

        // traverse from stk and append from back of the string
        while(!stk.isEmpty()){
            String top = stk.pop();
            ans = "/" + top + ans;
        }
        if(ans.isEmpty()){
            ans += "/";
        }
        return ans;
    }
}
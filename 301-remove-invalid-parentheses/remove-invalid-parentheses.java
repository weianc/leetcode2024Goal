class Solution {
    Set<String> res = new HashSet();
    int maxLen = 0;
    public List<String> removeInvalidParentheses(String s) {
        char[] arr = s.toCharArray();
        backtrack(arr, 0, new StringBuilder());
        List<String> ans = new ArrayList<>();
        for(String str : res){
            if(str.length() == maxLen){
                ans.add(str);
            }
        }
        return ans;
    }
    // 
    private void backtrack(char[] arr, int index, StringBuilder sb){
        if(index == arr.length){
            if(isValid(sb.toString())){
                res.add(sb.toString());
                maxLen = Math.max(maxLen, sb.toString().length());
            }
            return;
        }
        
        char c = arr[index];
        // 如果字符不是括号，就一定要保留
        if(c != '(' && c != ')')
        {
            sb.append(c);
            backtrack(arr, index + 1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else {
            // 选择保留当前括号
            sb.append(arr[index]);
            backtrack(arr, index + 1, sb);
            sb.deleteCharAt(sb.length()-1);
            // 选择不保留当前括号
            backtrack(arr, index + 1, sb);
        }

    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')') {
                if(count <= 0){
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}
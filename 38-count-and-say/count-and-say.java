class Solution {
    public String countAndSay(int n) {
        // base case 
        if(n == 1) return "1";
        String s = countAndSay(n-1);
        // iterate through s until s[i] != s[i+1]
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            counter++;
            // 表示可以結算s.charAt(i)的數目
            if(i == s.length() - 1 || s.charAt(i) != s.charAt(i+1)){
                sb.append(String.valueOf(counter));
                sb.append(s.charAt(i));
                // reset counter
                counter = 0;
            }
        }
        return sb.toString();
    }
}
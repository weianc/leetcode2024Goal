class Solution {
    public boolean validPalindrome(String s) {
        // when finding not mismatch situation:
        // left boundary: i, right boundary: j
        // check if s[i+1, j] and s[i, j-1] is palindrome or not
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                // 如果s[i+1, j]和s[i,j-1]都不是palindrome
                // 表示不符合情況
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    // 利用頭尾指針
    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
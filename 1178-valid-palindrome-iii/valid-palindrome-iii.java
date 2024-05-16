class Solution {
    public boolean isValidPalindrome(String s, int k) {
        // Method 1: DP bottom up with 2d array 
        // f[i][j]: 表示将子字符串 s[i,j] 变成回文字符串的最小删除次数
        // 1. initial condition: f[i][j] = 0
        // 2. s[i] = s[j]: f[i][j] = f[i+1][j-1]
        // 3. s[i] != s[j]: f[i][j] = 1+ max(f[i][j-1], f[i+1][j])
        int n = s.length();
        int[][] f = new int[n][n];

        if(n == 1) return true;
        // (1) i should not start from n-1, because checking substring length
        // should at least be 2
        // (2) j 從 i+1開始，因為應該從s[i,j]長度最小開始找可能性
        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    f[i][j] = f[i+1][j-1];
                }
                else {
                    // case 2: We need to take the minimum of the two results and add 1
                    // this is the cost of deletion
                    f[i][j] = 1 + Math.min(f[i][j-1], f[i+1][j]);
                }
            }
        }

        return f[0][s.length()-1] <= k;
    }
}
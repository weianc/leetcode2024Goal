class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1)
        int globalMin = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -101);
        }
        for(int c = 0; c < n; c++){
            globalMin = Math.min(globalMin, helper(matrix, n-1, c, n, memo));
        }
        return globalMin;
    }

    private int helper(int[][] matrix, int r, int c, int n, int[][] memo){
        if(r == 0){
            return matrix[r][c];
        }

        if(memo[r][c] != -101){
            return memo[r][c];
        }

        int ans = matrix[r][c];
        if(c == 0){
            ans += Math.min(helper(matrix, r - 1, c, n, memo), helper(matrix, r - 1, c + 1, n, memo));
        }
        else if (c == n - 1){
            ans += Math.min(helper(matrix, r - 1, c, n, memo), helper(matrix, r-1, c - 1, n, memo));
        }
        else {
            int up = helper(matrix, r - 1, c, n, memo);
            int leftUp = helper(matrix, r-1, c - 1, n, memo);
            int rightUp = helper(matrix, r - 1, c + 1, n, memo);
            ans += Math.min(Math.min(up, leftUp), rightUp);
        }
        memo[r][c] = ans;
        return ans;
    }
}
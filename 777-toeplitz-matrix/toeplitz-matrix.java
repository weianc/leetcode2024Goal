class Solution {
    // Solution 2: only compare to left-top neighbor
    public boolean isToeplitzMatrix(int[][] matrix) {
        // [m, n] -> [m+1, n+1]
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                // left top neighbor
                int pr = r + 1;
                int pc = c + 1;
                if(isBounded(pr, pc, m, n) && matrix[r][c] != matrix[pr][pc]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBounded(int r, int c, int m, int n){
        if(r >= 0 && r < m && c >= 0 && c < n) return true;
        return false;
    }
}
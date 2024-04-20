class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // [m, n] -> [m+1, n+1]
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(!visited[r][c]){
                    if(!isSameOnDiagonal(r, c, m, n, matrix, visited)){
                        return false;
                    };
                }
            }
        }
        return true;
    }

    private boolean isSameOnDiagonal(int r, int c, int m, int n, int[][] matrix, boolean[][] visited){
        int target = matrix[r][c];
        while(isBounded(r, c, m, n)) {
            visited[r][c] = true;
            if(matrix[r][c] != target){
                return false;
            }
            r = r + 1;
            c = c + 1;
        }
        return true;
    }

    private boolean isBounded(int r, int c, int m, int n){
        if(r >= 0 && r < m && c >= 0 && c < n){
            return true;
        }
        return false;
    }
}
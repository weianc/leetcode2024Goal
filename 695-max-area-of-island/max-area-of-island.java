class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1 && !visited[r][c]){
                    max = Math.max(max, traverse(grid, r, c, visited, m, n));
                }
            }
        }
        return max;
    }

    private int traverse(int[][] grid, int r, int c, boolean[][] visited, int m, int n){
        int sum = 1;
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isBounded(nr, nc, m, n) && !visited[nr][nc] && grid[nr][nc] == 1){
                sum += traverse(grid, nr, nc, visited, m, n);
            }
        }
        return sum;
    }

    private boolean isBounded(int r, int c, int m, int n){
        if(r >= 0 && r < m && c >= 0 && c < n) return true;
        return false;
    }
}
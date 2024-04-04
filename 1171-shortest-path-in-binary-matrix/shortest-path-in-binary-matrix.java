class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0][0] != 0){
            return -1;
        }
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] origin = {0, 0};
        q.offer(origin);
        int steps = 0;

        // 8 directions
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i = 0; i < size; i++){
                // find cur neighbor
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                if(curX == n-1 && curY == n-1){
                    return steps;
                }
                for(int d = 0; d < 8; d++){
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];
                    if(isBounded(nx,  ny, n) && !visited[curX][curY] && grid[nx][ny] == 0){
                        q.offer(new int[]{nx, ny});
                    }
                }
                visited[curX][curY] = true;
            }
        }

        return -1;
    }

    private boolean isBounded(int x, int y, int n){
        if(x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}
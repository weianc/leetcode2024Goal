class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    int globalMin = Integer.MAX_VALUE;
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int totalBuilding = 0;
        // calculate total building number
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    totalBuilding++;
                }
            }
        }

        // traverse with BFS for each 0 position
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int[] cur = {i, j};
                    int distancesForCur= traverseWithBFS(cur, grid, totalBuilding);
                    if(distancesForCur != -1){
                        globalMin = Math.min(distancesForCur, globalMin);
                    }
                }
            }
        }
        
        if(globalMin == Integer.MAX_VALUE){
            return -1;
        }
        return globalMin;
    }

    private int traverseWithBFS(int[] origin, int[][] grid, int totalBuilding){
        int totalDistance = 0;
        int m = grid.length;
        int n = grid[0].length;
        int or = origin[0];
        int oc = origin[1];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(origin);
        visited[or][oc] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                // find neighbor
                for(int d = 0; d < 4; d++){
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if(isBounded(nr, nc, m, n) && !visited[nr][nc] && grid[nr][nc] == 1){
                        totalDistance = totalDistance + steps + 1;
                        totalBuilding--;
                        visited[nr][nc] = true;
                    }
                    if(isBounded(nr, nc, m, n) && !visited[nr][nc] && grid[nr][nc] == 0){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            steps++;
        }
        return totalBuilding != 0 ? -1 : totalDistance;
    }

    private boolean isBounded(int r, int c, int m, int n){
        if(r < m && c < n && r >= 0 && c >= 0){
            return true;
        }
        return false;
    }
}
class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int globalMax = 0;
        // indicate the position belongs to which island
        int[][] tag = new int[n][n];
        Map<Integer, Integer> area = new HashMap<>();

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                // tag[r][c]必須是0，否則如果是1的話其實已經計算過了
                if(grid[r][c] == 1 && tag[r][c] == 0){
                    int t = r * n + c + 1;
                    int islandArea = traverse(grid, r, c, tag, n, t);
                    area.put(t, islandArea);
                    globalMax = Math.max(globalMax, islandArea);
                }
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                // when found one 0, start to traver [r, c] neighbor
                // see if there are island nearby [r, c]
                if(grid[r][c] == 0){
                    // find neighbor
                    int currArea = 1;
                    Set<Integer> connectedPoint = new HashSet();
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        //int nt = tag[nr][nc];
                        if(isBounded(nr, nc, n) && tag[nr][nc] != 0 && !connectedPoint.contains(tag[nr][nc])){
                            int nt = tag[nr][nc];
                            currArea += area.get(nt);
                            connectedPoint.add(nt);
                        }
                    }
                    globalMax = Math.max(globalMax, currArea);
                }
            }
        }

        return globalMax;
    }

    private int traverse(int[][] grid, int r, int c, int[][] tag, int n, int t){
        int sum = 1;
        tag[r][c] = t;
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isBounded(nr, nc, n) && tag[nr][nc] == 0 && grid[nr][nc] == 1){
                sum += traverse(grid, nr, nc, tag, n, t);
            }
        }
        return sum;
    }

    private boolean isBounded(int r, int c, int n){
        if(r >= 0 && r < n && c >= 0 && c < n) return true;
        return false;
    }
}
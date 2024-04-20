class Solution {
    // Solution 2: Predict diagonal direction
    public int[] findDiagonalOrder(int[][] mat) {
        // 1. diagonal: {r -1, c + 1}, (row + col) % 2 == 0
        // 1.1 c == n-1: column should not increase, r + 1
        // 1.2 r == 0: row should not decrease, c + 1
        // 1.3 c < n-1 && r > 0: r - 1, c + 1
        // 2. reverse diagonal: {r + 1, c - 1}, {row + col} % 2 == 1
        // 2.1: r == m - 1: // 下边到底了，要换方向，坐标(r, c+1), 
        // row should not increase, c + 1
        // 2.2: c == 0: // 左边到底了，要换方向，坐标(r+1, c)
        // col should not decrease, r + 1
        // 2.3: c > 0 && r < m-1: {r+1, c-1}
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0;
        int c = 0;
        for(int i = 0; i < res.length; i++){
            // assign to res first
            res[i] = mat[r][c];
            int sum = r + c;
            // 1. diagonal {r - 1, c + 1} 
            if(sum % 2 == 0){
                if(c == n - 1){
                    // 已經到右邊界，換方向r+1
                    r += 1;
                }
                else if (r == 0){
                    // 已經到上邊界，換方向c+1
                    c += 1;
                }
                else {
                    // r,c都在邊界
                    r -= 1;
                    c += 1;
                }
            }
            // 2. reverse diagonal {r + 1, c - 1} 
            else {
                if(r == m - 1){
                    // 已經到下邊界，換方向 c + 1
                    c += 1;
                }
                else if (c == 0){
                    // 已經到左邊界，換方向r+1
                    r += 1;
                }
                else {
                    r += 1;
                    c -= 1;
                }
            }
        }
        return res;
    }
}
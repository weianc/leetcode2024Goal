class TicTacToe {
    private int[][] grid;
    public TicTacToe(int n) {
        grid = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        return isPlayerWin(player, row, col, grid.length);
    }

    private int isPlayerWin(int player, int row, int col, int n){
        // assign grid[row][col]
        grid[row][col] = player;
        int count = 0;

        // row
        for(int c = 0; c < n; c++){
            if(grid[row][c] == player){
                count++;
            }
            else {
                break;
            }
            if(count == n) return player;
        }
        count = 0;
            
        // col
        for(int r = 0; r < n; r++){
            if(grid[r][col] == player){
                count++;
            }
            else {
                break;
            }
            if(count == n) return player;
        }
        
        count = 0;

        // diagonal 
        if(isOnDiagonal(row, col, n)){
            for(int i = 0; i < n; i++){
                if(grid[i][i] != player){
                    break;
                }
                else {
                    count++;
                }

                if(count == n){
                    return player;
                }
            }
            count = 0;

            for(int i = 0; i < n; i++){
                int r = i;
                int c = n - 1 - i;
                if(grid[r][c] != player){
                    break;
                }
                else {
                    count++;
                }

                if(count == n){
                    return player;
                }
            }
        }
        return 0;
    }

    private boolean isOnDiagonal(int row, int col, int n){
        if(row + col == n-1 || row == col){
            return true;
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
public class CutSlash {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int count = 0;
        int[][] newGrid = new int[n*3][m*3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char cut = grid[i].charAt(j);
                int a = i * 3;
                int b = j * 3;
                if(cut == '\\'){
                    newGrid[a][b] = 1;
                    newGrid[a + 1][b + 1] = 1;
                    newGrid[a + 2][b + 2] = 1;
                }else if(cut == '/'){
                    newGrid[a][b + 2] = 1;
                    newGrid[a + 1][b + 1] = 1;
                    newGrid[a + 2][b] = 1;
                }
            }
        }
        for(int i = 0; i < newGrid.length; i++){
            for(int j = 0; j < newGrid[0].length; j++){
                if(newGrid[i][j] == 0){
                    performDFS(newGrid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void performDFS(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = {0, -1, 0, 1, 0};
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 1){
            return;
        }
        grid[i][j] = 1;
        for(int k = 0; k <= 3; k++){
            performDFS(grid,i + arr[k],j + arr[k + 1]);
        }
    }
}

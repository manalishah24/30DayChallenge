package Day1;

public class MaxAreaOfIsland {
	
	public static void main(String[] args) {
		MaxAreaOfIsland m = new MaxAreaOfIsland();
		int[][] grid = {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,1}};
		System.out.println(m.maxAreaOfIsland(grid));
	}
	
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int count = dfs(i, j, row, col, grid);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
    private int dfs(int i, int j, int row, int col, int[][] grid){
        if(i >= 0 && j >= 0 && i < row && j < col && grid[i][j] == 1){
            int ct = 1;
            grid[i][j] = -1;
            ct += dfs(i+1, j, row, col, grid);
            ct += dfs(i-1, j, row, col, grid);
            ct += dfs(i, j+1, row, col, grid);
            ct += dfs(i, j-1, row, col, grid);
            return ct;
        }
        return 0;
    }
}

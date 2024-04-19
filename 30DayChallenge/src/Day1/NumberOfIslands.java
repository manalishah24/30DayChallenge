package Day1;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println(noi.numIslands(grid));
	}
	
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, row, col, grid);
                    count += 1;
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, int row, int col, char grid[][]){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(i+1, j, row, col, grid);
        dfs(i-1, j, row, col, grid);
        dfs(i, j+1, row, col, grid);
        dfs(i, j-1, row, col, grid);
    }
}

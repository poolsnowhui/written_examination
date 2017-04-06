public class Homes {
	public static int countHomes(int grid[][]) {

		int n = grid.length;
		int m = grid[0].length;
		int ks = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j]==1){
					grid[i][j]=0;
					neighbor(i,j,grid);//把neighbor的所有邻居置为0；
					ks++;
				}
			}
		}
		return ks;
	}

	private static void neighbor(int a, int b,int[][] grid) {
		if(a+1>=grid.length&&b+1>=grid[0].length){
			return;
		}else if(a+1<grid.length)
			if(grid[a+1][b]==1){
				{grid[a+1][b]=0;
				neighbor(a+1, b, grid);
				}
		}else if(b+1<grid[0].length){
			if(grid[a][b+1]==1){
				grid[a][b+1]=0;
				neighbor(a, b+1, grid);
			}
		}else if(a-1>=0){
			if(grid[a-1][b]==1){
				grid[a-1][b]=0;
				neighbor(a-1, b, grid);
			}
		}else if(b-1>=0){
			if(grid[a][b-1]==1){
				grid[a][b-1]=0;
				neighbor(a, b-1, grid);
			}
		}else{
			return;
		}
	}
	public static void main(String[] args) {
		int [][] g = {{1,0,1,0},{1,0,0,0},{1,0,1,0},{1,0,1,0}};
		System.out.println(countHomes(g));
	}
}
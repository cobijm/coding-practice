package easy;

public class RottingOranges {
	
	public static int orangesRotting2(int[][] grid) {
		return 1;
	}
	public static int orangesRotting(int[][] grid) {
		int numMins = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && grid[i + 1][j] < 1 && grid[i - 1][j] < 1 && grid[i][j - 1] < 1
						&& grid[i][j - 1] < 1) {
					return -1;
				}
				if (grid[i][j] == 2) {
					grid[i][j + 1] += 1;
					grid[i + 1][j] += 1;
					numMins++;
				}
			}
		}
		return numMins;
	}

	public static void main(String[] args) {
		int[][] test =  {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(test));

	}

}

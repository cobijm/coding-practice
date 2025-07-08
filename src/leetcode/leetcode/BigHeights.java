package leetcode;

public class BigHeights {

	public int bigHeights(int[] heights, int start, int end) {
		  int bigSteps = 0;
		  for(int i = start; i < end; i++) {
		    if(Math.abs(heights[i + 1] - heights[i]) > 4) {
		      bigSteps++;
		    }
		  }
		  return bigSteps;
		}
}

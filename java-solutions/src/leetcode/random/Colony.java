package random;

import java.util.Arrays;

public class Colony {

	public static int[] cellCompete(int[] cells, int days)
	  {
	    // INSERT YOUR CODE HERE
	    int[] cellReturn = new int[cells.length];
	    for(int i = 0; i < days; i++) {
	        //check for first cell state
	        if(cells[1] == 0) {
	            cellReturn[0] = 0;
	        }
	        else {
	            cellReturn[0] = 1;
	        }
	        //check for last cell state
	        if(cells[cells.length - 2] == 0) {
	            cellReturn[cellReturn.length - 1] = 0;
	        }
	        else {
	            cellReturn[cellReturn.length - 1] = 1;
	        }
	        for(int j = 1; j < cells.length - 1; j++) {
	            if(cells[j - 1] == cells[j + 1]) {
	                cellReturn[j] = 0;
	            }
	            else {
	                cellReturn[j] = 1;
	            }
	        }
	        cells = cellReturn;
	    }
	    return cells;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 1, 1, 0, 1, 1, 1, 1};
		System.out.println(test[test.length - 1]);
		System.out.println(Arrays.toString(cellCompete(test, 2)));

	}

}

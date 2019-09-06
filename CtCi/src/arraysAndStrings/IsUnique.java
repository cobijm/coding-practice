package arraysAndStrings;

/*
 * 1.1
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

	public boolean isUniqueBrute(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isUniqueOptimized(String str) {
		//array of booleans with length of number of possible values
		boolean[] charSet = new boolean[128];
		
		//loop through str and check if boolean at str.value already exists
		for(int i = 0; i < str.length(); i++) {
			//if character has already been checked as true, return false
			if(charSet[str.charAt(i)]) {
				return false;
			}
			//make boolean value at str.value become true
			charSet[str.charAt(i)] = true;
		}
		return true;
	}
}
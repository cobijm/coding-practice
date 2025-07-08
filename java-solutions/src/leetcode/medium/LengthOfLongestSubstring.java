package medium;

import java.util.HashSet;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		
		if(s == null) {
			return 0;
		}
		
		HashSet<Character> charSet = new HashSet<>();
		int high = 0;
		int front = 0;
		int back = 0;
		
		//while sliding window hasn't closed reached the end of the string
		while(front < s.length() && back < s.length()) {
			// if char at end of sliding window is unique, add it to charSet extend backend of window
			if(!charSet.contains(s.charAt(back))) { 
				charSet.add(s.charAt(back));
				back++;
				high = Math.max(high, back - front);
				//if char is not unique, it is the front that conflicts so remove that
			} else {
				charSet.remove(s.charAt(front));
				front++;
			}
		}
		return high;
	}

	public static void main(String[] args) {
		String test = "dvdf";
		System.out.println(lengthOfLongestSubstring(test));
	}

}

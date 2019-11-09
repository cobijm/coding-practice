package easy;

import java.util.HashMap;

public class FirstUniqueCharacter {
	
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charSet = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
            charSet.put(temp, charSet.getOrDefault(temp, 0) + 1);
        }
        
        for(int j = 0; j < s.length(); j++) {
        	char temp = s.charAt(j);
            if(charSet.get(temp) == 1) {
                return j;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		String test = "leetcode";
		System.out.println(firstUniqChar(test));
	}

}

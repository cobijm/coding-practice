package leetcode;

public class longestSubstring {
	public static int lengthOfLongestSubstring(String s) {
        String result = "";
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < result.length(); j++) {
                if(result.charAt(j) == s.charAt(i)) {
                    result = result.substring(j + 1);
                    break;
                }
            }
            result += s.charAt(i);
            if(max < result.length()) {
                max = result.length();
            }
        }
        return max;
    }
	public static void main(String[] args) {
		String test = "dvdf";
		System.out.println(lengthOfLongestSubstring(test));

	}
}

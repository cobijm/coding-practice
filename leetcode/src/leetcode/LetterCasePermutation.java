package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LetterCasePermutation {

	public static List<String> letterCasePermutation(String S) {
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		set.add(S);
		char[] str = S.toCharArray();
		result.add(S);
		for (int i = 0; i < str.length; i++) {
			char[] temp = str.clone();
			if (Character.isLetter(str[i])) {
				for (int j = i; j < str.length; j++) {
					String tmp = alternate(temp, j);
					if (!set.contains(tmp)) {
						result.add(tmp);
						set.add(tmp);
					}
				}
			}
		}
		return result;
	}

	public static String alternate(char[] str, int index) {
		if (Character.isLowerCase(str[index])) {
			str[index] = Character.toUpperCase(str[index]);
		} else {
			str[index] = Character.toLowerCase(str[index]);
		}
		return String.copyValueOf(str);
	}

	public static void main(String[] args) {
		String test = "a1b2";
		List<String> test2 = letterCasePermutation(test);
		for (String s : test2) {
			System.out.println(s);
		}

	}
}

package others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s) {
		HashMap<Character, Character> complements = new HashMap<>();
		complements.put(')', '(');
		complements.put('}', '{');
		complements.put(']', '[');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (complements.containsKey(temp)) {
				char top = stack.empty() ? 'Z' : stack.pop();
				if (top != complements.get(temp)) {
					return false;
				}
			} else {
				stack.push(temp);
			}
		}
		return stack.isEmpty();
	}

	public static boolean isValidFirstTry(String s) {
		if (s == "") {
			return true;
		}
		HashSet<Integer> set = new HashSet<>();
		// let ( = 1, { = 2, [ = 3
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == '(') {
				set.add(1);
			} else if (temp == ')') {
				set.remove(1);
			} else if (temp == '{') {
				set.add(2);
			} else if (temp == '}') {
				set.remove(2);
			} else if (temp == '[') {
				set.add(3);
			} else if (temp == ']') {
				set.remove(3);
			}
		}
		return set.size() == 0;
	}

	public static void main(String[] args) {
		String test = "([)]";
		System.out.println(isValid(test));

	}

}

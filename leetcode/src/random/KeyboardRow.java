package random;

import java.util.ArrayList;
import java.util.HashSet;

public class KeyboardRow {
	public String[] findWords(String[] words) {
		HashSet<Character> row1 = new HashSet<Character>();
		HashSet<Character> row2 = new HashSet<Character>();
		HashSet<Character> row3 = new HashSet<Character>();
		ArrayList<String> result = new ArrayList<String>();
		row1.add('q');
		row1.add('w');
		row1.add('e');
		row1.add('r');
		row1.add('t');
		row1.add('y');
		row1.add('u');
		row1.add('i');
		row1.add('o');
		row1.add('p');

		row2.add('a');
		row2.add('s');
		row2.add('d');
		row2.add('f');
		row2.add('g');
		row2.add('h');
		row2.add('j');
		row2.add('k');
		row2.add('l');

		row3.add('z');
		row3.add('x');
		row3.add('c');
		row3.add('v');
		row3.add('b');
		row3.add('n');
		row3.add('m');

		for (int i = 0; i < words.length; i++) {
			if (compare(row1, words[i].toLowerCase()) || compare(row2, words[i].toLowerCase())
					|| compare(row3, words[i].toLowerCase())) {
				result.add(words[i]);
			}
		}
		String[] stockArr = new String[result.size()];
		stockArr = result.toArray(stockArr);
		return stockArr;

	}

	public boolean compare(HashSet<Character> row, String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!row.contains(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}

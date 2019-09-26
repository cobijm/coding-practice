package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 884. Uncommon Words from Two Sentences
 */
public class UncommonFromSentences {
	
	public static String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        addWords(map, A);
        addWords(map, B);
        ArrayList<String> uncommons = new ArrayList<>();
        for(String s: map.keySet()) {
        	if(map.get(s) == 1) {
        		uncommons.add(s);
        	}
        }
        String[] result = new String[uncommons.size()];
        result = uncommons.toArray(result);
        return result;
    }
    public static void addWords(HashMap<String, Integer> map, String str) {
        String word = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
            	if(map.get(word) == null) {
            		map.put(word, 1);
            	} else {
            		map.put(word, map.get(word) + 1);
            	}
            	word = "";
            } else {
                word += str.charAt(i);
            }
        }
    	if(map.get(word) == null) {
    		map.put(word, 1);
    	} else {
    		map.put(word, map.get(word) + 1);
    	}
    }
	public static void main(String[] args) {
		String test1 = "this apple is sweet";
		String test2 = "this apple is sour";
		System.out.println(Arrays.toString(uncommonFromSentences(test1, test2)));
	}

}

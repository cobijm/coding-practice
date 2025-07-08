package easy;

import java.util.*;

/* Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 */
public class ReverseVowels {

    public static String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        List<Character> vowelsInOrder = new ArrayList<>();
        // find vowels
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(vowels.contains(curr)) {
                vowelsInOrder.add(curr);
            }
        }
        Collections.reverse(vowelsInOrder);
        StringBuilder res = new StringBuilder();
        // go back and replace vowels in reverse order
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(vowels.contains(curr)) {
                res.append(vowelsInOrder.get(0));
                vowelsInOrder.remove(0);
            } else {
                res.append(curr);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String test = "leetcode";
        System.out.println(reverseVowels(test));
    }
}

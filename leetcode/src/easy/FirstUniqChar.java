package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for(int j = 0; j < s.length(); j++) {
            if(!set.contains(s.charAt(j))) {
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

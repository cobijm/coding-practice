package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {
	
	public static List<String> fizzBuzzNaive(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 5 == 0 && i % 3 == 0) {
                result.add("FizzBuzz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else if(i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
	public static List<String> fizzBuzzStrConcat(int n) {
		List<String> result = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String temp = "";
			if(i % 3 == 0) {
				temp += "Fizz";
			}
			if(i % 5 == 0) {
				temp += "Buzz";
			}
			if(temp == "") {
				temp += Integer.toString(i);
			}
			result.add(temp);
		}
		return result;
	}
	public static List<String> fizzBuzzHash(int n) {
		List<String> result = new ArrayList<>();
		HashMap<Integer, String> hash = new HashMap<>();
        hash.put(3, "Fizz");
		hash.put(5, "Buzz");
		
		for(int i = 1; i <= n; i++) {
			String temp = "";
			for(Integer key : hash.keySet()) {
				if(i % key == 0) {
					temp += hash.get(key);
				}
			}
            if(temp == "") {
                temp += Integer.toString(i);
            }
            result.add(temp);
		}
		return result;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

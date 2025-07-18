package easy;

import java.util.ArrayList;
import java.util.List;

/* 412. Fizz Buzz
 */
public class FizzBuzz {

	//Naive solution, O(n)
	public static List<String> fizzBuzzNaive(int n) {
		List<String> result = new ArrayList<>();
		for(int i = 1; i<= n; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
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
	
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            result.add(FB(i));
        }
        return result;
    }
    public static String FB(int n) {
        if(n % 5 == 0) {
            if(n % 3 == 0) {
                return "FizzBuzz";
            } else {
                return "Buzz";
            }
        } else if(n % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf(n);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 15;
//		System.out.println(fizzBuzzNaive(test));
		System.out.println(fizzBuzz(test));

	}

}

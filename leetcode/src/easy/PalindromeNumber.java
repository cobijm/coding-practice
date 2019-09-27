package easy;

/*
 * 9. Palindrome Number
 */
public class PalindromeNumber {

	//naive O(n)
    public static boolean isPalindrome(int x) {
    	if(x < 0) {
    		return false;
    	}
        String str = Integer.toString(x);
        
        String str2 = reverser(str);
        if(str2.equals(str)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isPalindrome2(int x) {
        if(x < 0) {
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }
    
    public static String reverser(String word) {
		String reversed = "";
		for (int i = word.length() - 1; i > -1; i--) {
			reversed += word.charAt(i);
		}
		return reversed;
	}
    
    public static void main(String[] args) {
    	int test = 121;
    	System.out.println(isPalindrome2(test));
    }
}

package strings;


public class StringPalindrome {
	
	public static boolean isPalindrome(String s) {
		StringBuilder str = new StringBuilder();
		StringBuilder strRev = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if((Character.isLetter(temp)) || (Character.isDigit(temp))) {
                str.append(Character.toLowerCase(temp));
                strRev.append(Character.toLowerCase(temp));
            }
        }
        
        strRev.reverse();
		System.out.println(str);
		System.out.println(strRev);
		if(str.toString().equals(strRev.toString())) {
			return true;
		}
		return false;
    }
	
	public static boolean isPalindromeSB(String s) {
		StringBuilder str = new StringBuilder(s);
		StringBuilder strRev = new StringBuilder(s);
		strRev.reverse();
		System.out.println(str);
		if(str.equals(strRev)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String test = "A man, a plan, a canal: Panama";
		//String test1 = "0P";
		System.out.println(isPalindrome(test));

	}

}

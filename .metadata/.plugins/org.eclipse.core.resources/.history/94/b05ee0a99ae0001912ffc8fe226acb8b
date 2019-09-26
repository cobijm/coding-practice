package leetcode;

public class ReverseWords {
	
	public String reverseWords(String s) {
		String word = "";
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				result += reverser(word) + " ";
				word = "";
			}
			else {
				word += s.charAt(i);
			}
		}
		return result + reverser(word);
	}

	public String reverseWordsSB(String s) {
        String words[] = s.split(" ");
        StringBuilder result=new StringBuilder();
        for (String word: words) {
            result.append(new StringBuffer(word).reverse().toString() + " ");
        }
        return result.toString().trim();
    }


	public static String reverser(String word) {
		String reversed = "";
		for (int i = word.length() - 1; i > -1; i--) {
			reversed += word.charAt(i);
		}
		return reversed;
	}
	
	public static void main(String[] args) {
		String test = "yellow";
		System.out.println(reverser(test));
	}
}

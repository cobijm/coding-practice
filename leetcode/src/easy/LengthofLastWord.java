package easy;

/*
 * 58. Length of Last Word
 */
public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        String[] words = s.split(" ");
        if(words.length < 1) {
        	return 0;
        }
        return words[words.length - 1].length();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "Hello World";
		System.out.println(lengthOfLastWord(test));

	}

}

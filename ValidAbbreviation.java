package leetcode;

public class ValidAbbreviation {
	public static void main(String[] args) {
//		validWordAbbreviation("word", "word" );
//		validWordAbbreviation("word",  "1ord");
//		validWordAbbreviation("word",  "w1rd");
//		validWordAbbreviation("word",  "wo1d");
//		validWordAbbreviation("word",  "wor1");
//		validWordAbbreviation("word",  "2rd" );
//		validWordAbbreviation("word",  "w2d" );
//		validWordAbbreviation("word",  "wo2" );
//		validWordAbbreviation("word",  "1o1d");
//		validWordAbbreviation("word",  "1or1");
//		validWordAbbreviation("word",  "w1r1");
//		validWordAbbreviation("word",  "1o2" );
//		validWordAbbreviation("word",  "2r1" );
//		validWordAbbreviation("word",  "3d"  );
//		validWordAbbreviation("word",  "w3"  );
//		validWordAbbreviation("word",  "4"   );
//		validWordAbbreviation("internationalization","i12iz4n");
		validWordAbbreviation("apple","a2e");
	}
	
	public static boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		
		while(i < abbr.length() && j<word.length()){
			if(Character.isAlphabetic(abbr.charAt(i))){
				if(word.charAt(j) != abbr.charAt(i)) 
					return false;
				i++; j++;
			}else{
				int len = 0;
				while(i<abbr.length() && Character.isDigit(abbr.charAt(i))){
					len*=10;
					len+=Integer.valueOf(abbr.substring(i, i+1));
					i++;
				}
				if(word.length() < j+len) return false;
				j+=len;
			}
		}
		
		boolean b = (j==word.length() && i == abbr.length());
		System.out.println("word =" + word + ", abbr=" + abbr + (b ? "true" : "false"));
		return b;
	}
}

import java.util.*;

class VowelOrConsonant {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Input Character");
		char ch = reader.next().charAt(0);
		boolean isVowel=false;

		char[] vowels = {'a', 'e', 'i', 'o', 'u'};


		for (char item : vowels) {
			if(ch==item)
				isVowel=true;
		}

		if(isVowel)
			System.out.println(ch + " is a vowel");
		else
			System.out.println(ch + " is a consonant");

		reader.close();
	}
}
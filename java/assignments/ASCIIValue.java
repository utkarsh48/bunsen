import java.util.*;

class ASCIIValue {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Input Character");
		char ch = reader.next().charAt(0);

		System.out.println("ASCII value of " + ch+ " is "+ (int)ch);

		reader.close();
	}
}
import java.util.*;

class InputFromUser {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Input int");
		int intgr = reader.nextInt();

		System.out.println("Input float");
		float flot = reader.nextFloat();

		reader.nextLine();

		System.out.println("Input string");
		String str = reader.nextLine();

		System.out.println("Integer input = "+intgr);
		System.out.println("Float input = "+flot);
		System.out.println("String input = "+str);

		reader.close();
	}
}
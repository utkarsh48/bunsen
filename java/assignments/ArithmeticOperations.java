import java.util.*;

class ArithmeticOperations {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int a = reader.nextInt();

		System.out.println("Enter second number: ");
		int b = reader.nextInt();
		
		System.out.print("\nEnter corresponding character of operation to perform?\naddition: a\nsubtraction: s\nmultiplication: m\ndivision: d\n");

		char operator = reader.next().charAt(0);
		System.out.println("\n");

		switch(operator){
			case 'a':
			System.out.println("addition: "+ (a+b));
			break;

			case 's':
			System.out.println("subtraction: "+ (a-b));
			break;

			case 'm':
			System.out.println("multiplication: "+ (a*b));
			break;

			case 'd':
			System.out.println("division: "+ ((float)a/b));
			break;

			default:
				System.out.println("Wrong input");
		}


		reader.close();
	}
}
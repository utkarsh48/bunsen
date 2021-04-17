import java.util.*;

class CalculateArea {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		double area=0;
		System.out.print("\nEnter corresponding character of shape to calculate area?\ncircle: c\nsquare: s\nrectangle: r\ntriangle: t\n");

		char operator = reader.next().charAt(0);
		System.out.println("\n");

		switch(operator){
			case 'c':
			System.out.println("Enter radius of circle:");
			double radius = reader.nextFloat();
			area = Math.PI * radius * radius;
			break;

			case 's':
			System.out.println("Enter side of square:");
			double side = reader.nextFloat();
			area = side * side;
			break;

			case 'r':
			System.out.println("Enter length of rectangle:");
			double length = reader.nextFloat();
			System.out.println("Enter breadth of rectangle:");
			double breadth = reader.nextFloat();
			area = length * breadth;
			break;

			case 't':
			System.out.println("Enter length of base of triangle:");
			double base = reader.nextFloat();
			System.out.println("Enter height of triangle:");
			double height = reader.nextFloat();
			area = 0.5 * base * height;
			break;

			default:
				System.out.println("Wrong input");
		}
		System.out.println("Calculated area: " +area);

		reader.close();
	}
}
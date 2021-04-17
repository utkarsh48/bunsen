import java.util.*;

class LeapYearCheck {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Input year: ");

		int year = reader.nextInt();

		if (year%400==0)
			System.out.println(year+" is a leap year");
		else if (year%100==0)
			System.out.println(year+" is not a leap year");
		else if(year%4==0)
			System.out.println(year+" is a leap year");
		else
			System.out.println(year+" is not a leap year");

		reader.close();
	}
}
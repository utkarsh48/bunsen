import java.util.*;

class MinutesToYears {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter minutes:");
		
		float minutes = reader.nextFloat();

		int days = (int)minutes/1440;

		int years = (int)days/365;

		int daysLeft = (int)days%365;

		System.out.println(years+ " years and "+ daysLeft+" days");

		reader.close();
	}
}

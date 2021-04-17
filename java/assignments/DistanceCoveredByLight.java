import java.util.*;

class DistanceCoveredByLight {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter number of days: ");
		int days = reader.nextInt();
		final int SPEED_OF_LIGHT = 186000;
		long result = (long)days * 24 * 60 * 60 * SPEED_OF_LIGHT;

		System.out.println("Light will travel " + result + " miles");
		
		reader.close();
	}
}

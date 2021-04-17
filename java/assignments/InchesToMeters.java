import java.util.*;

class InchesToMeters {
	public static void main(String[] args) {
		float CONVERSION_FACTOR = .0254f;

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter inches:");
		float inches = reader.nextFloat();

		System.out.println(inches+ " inches is equal to "+(inches*CONVERSION_FACTOR) + " meters");

		reader.close();
	}
}
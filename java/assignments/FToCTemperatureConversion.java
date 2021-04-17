import java.util.*;

class FToCTemperatureConversion {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter temperature in Farenheit without units:");
		float f = reader.nextInt();
		float c = (f - 32)*5/9;

		System.out.println(f+" degree farenheit is equal to "+c+" degree celsius");

		reader.close();
	}
}
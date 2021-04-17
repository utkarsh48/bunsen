import java.util.*;

class UserInputArray {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
	
		System.out.println("Enter size of array");
		int n = reader.nextInt();

		int[] array = new int[n];
		
		for(int i=0; i<n; i++){
			System.out.println("input for "+i+"th element:");
			array[i]=reader.nextInt();
		}

		System.out.println(Arrays.toString(array));

		reader.close();
	}
}
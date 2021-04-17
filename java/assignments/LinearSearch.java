import java.util.*;

class LinearSearch {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int[] arr = {23, 6, 2, 7, 34, 1, 6, 90, 24, 89};
		int index=-1;


		System.out.println(Arrays.toString(arr));

		System.out.println("Enter element to search");
		int toSearch = reader.nextInt();

		for (int i=0; i<arr.length; i++) {
			if(arr[i]==toSearch){
				index=i;
				break;
			}
		}

		if(index==-1)
			System.out.println("Not found");
		else
			System.out.println("Found at index "+index);
	}
}
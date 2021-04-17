import java.util.*;

class BinarySearch {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int[] array = {10, 20, 30, 40, 50, 60, 70, 80};

		System.out.println(Arrays.toString(array));

		System.out.println("Input the element to search in the array: ");
		int item = reader.nextInt();

		int top = 0, bottom = array.length-1;
		int middle = 0;
		int index = -1;

		while (top <= bottom) {
			middle = (top + bottom)/2;
			if(item == array[middle]){
				index = middle;
				break;
			}
			else if(item > array[middle]){
				top = middle+1;
			}
			else if(item < array[middle]){
				bottom = middle-1;
			}
		}

		if((top == middle) && (middle == bottom) && (item == array[middle])){
			index = middle;
		}

		if(index==-1)	System.out.println("Not Found");
		else System.out.println("Found at index "+index);
	}
}
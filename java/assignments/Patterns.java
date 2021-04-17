class Patterns {
	public static void main(String[] args) {


		//decending half piramid
		System.out.println("descending half pyramid\n");
		for (int i = 1; i<=5; i++) {
			for (int j = 1; j<=i ; j++ ) {
				System.out.print("*");
			}
			System.out.println("");
		}

		//assending half piramid
		System.out.println("\n\nascending half pyramid\n");
		for (int i = 5; i>=1; i--) {
			for (int j = 1; j<=i ; j++ ) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
}

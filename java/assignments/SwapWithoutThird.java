class SwapWithoutThird {
	public static void main(String[] args) {
		int a = 12;
		int b = 5;

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		a=a+b;
		b=a-b;
		a=a-b;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
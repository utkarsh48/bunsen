class AllPrimitiveDataTypes {
	public static void main(String[] args) {
		byte a = 127;
		short b = 32767;
		int c = 2147483647;
		long d = 9223372036854775807L;
		float e = 5.90f;
		float castedC = (float)c;
		double f = 9.00000101090999d;
		double castedE = (double)e;
		char g = 'y';
		boolean h = true;

		System.out.println("byte: "+a);
		System.out.println("short: "+b);
		System.out.println("int: "+c);
		System.out.println("long: "+d);
		System.out.println("float: "+e);
		System.out.println("double: "+f);
		System.out.println("char: "+g);
		System.out.println("boolean: "+h);

	}
}
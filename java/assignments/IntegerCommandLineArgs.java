class IntegerCommandLineArgs{
	public static void main(String[] args) {
		Integer output = 0;
		
		for (Integer i=0; i<args.length; i++) {
			output+=Integer.parseInt(args[i]);
		}

		System.out.println(output);
	}
}

// javac IntegerCommandLineArgs.java && java IntegerCommandLineArgs 2 4 6 8 10

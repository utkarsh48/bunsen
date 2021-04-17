class StringCommandLineArgs{
	public static void main(String[] args) {
		String[] commandLineArgs = args;
		String output = "";

		for (String arg: commandLineArgs) {
			output+=arg+" ";
		}

		System.out.println(output);
	}
}

// javac StringCommandLineArgs.java && java StringCommandLineArgs Guru Nanak Dev University

class AllInheritances {
	public static void main(String[] args) {
		LivingThing lt = new Human();
		lt.lives();

		Plant plnt = new Plant();
		plnt.photosynthesis();

		Herb hrb = new Herb();
		hrb.character();

		Shurb shrb = new Shurb();
		shrb.character();

		Animal anml = new Animal();
		anml.moves();

		Human humn = new Human();
		humn.moves();
	}
}

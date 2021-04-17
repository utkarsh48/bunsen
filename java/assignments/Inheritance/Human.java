public class Human extends Animal{
	public void speak(){
		System.out.println("speaking...");
	}

	@Override
	public void moves(){
		System.out.println("walking...");
	}
}

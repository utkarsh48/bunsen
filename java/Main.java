public interface InnerMain {
  public void name(){
    System.out.println("this is real name()");
  };
}

public class Main implements InnerMain{
  public static void main(String[] args) {
    System.out.println("hello world");
    Main obj1 = new Main();
    obj1.name();
  }

  @Override
  public void name(){
    System.out.println("this is name()...");
  }
}
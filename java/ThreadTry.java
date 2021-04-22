public class ThreadTry implements Runnable {
  public static void main(String[] args) {
    ThreadTry tain = new ThreadTry();

    Thread thread = new Thread(tain);
    thread.start();
    while (thread.isAlive()) {
      System.out.println("processing..!");
    }
    System.out.println("Complete");
  }

  public void run() {
    System.out.println("Thread running...");
  }
}
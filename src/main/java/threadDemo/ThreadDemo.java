package threadDemo;

public class ThreadDemo extends Thread{

	public void run(){
		for (int i = 0; i < 60; i++) {
			System.out.println("demo run --- "+i);
		}
	}
}

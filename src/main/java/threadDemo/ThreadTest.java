package threadDemo;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		td.start();
		//td.run(); //仅仅是执行run方法，而线程创建了并没有运行
		for (int i = 0; i < 60; i++) {
			System.out.println("main run ------ "+i);
		}
	}

}

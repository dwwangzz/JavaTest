package threadDemo.demo1;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadDemo td1 = new ThreadDemo("one");
		ThreadDemo td2 = new ThreadDemo("two");
		td1.start();
		td2.start();
		//td.run(); //仅仅是执行run方法，而线程创建了并没有运行
		for (int i = 0; i < 60; i++) {
			System.out.println("main run ------ "+i);
		}
	}

}

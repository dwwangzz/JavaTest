package threadDemo.demo1;

public class ThreadDemo extends Thread{

	//传入一个线程名称
	ThreadDemo(String name){
		super(name);
	}

	@Override
	public void run(){
		for (int i = 0; i < 60; i++) {
			System.out.println(this.getName()+" run --- "+i);

			//System.out.println("--this:"+this);
			//Thread.currentThread()返回当前运行线程对象 这里就等同于this
			//System.out.println("--Thread.currentThread():"+Thread.currentThread());
		}
	}
}

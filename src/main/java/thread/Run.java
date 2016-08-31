package thread;

public class Run {
    public static void main(String[] args) throws Exception {
        TestThread testThread = new TestThread();
        testThread.start();
        //1秒之后执行
        //Thread.sleep(10000);
        testThread.stop();
        
		/*long c = System.currentTimeMillis();
		for(int i=1;i<100;i++){
			String time = (System.currentTimeMillis() - c)/1000.0f + " s";
			Thread.sleep(1000);
			System.out.println(time);
		}
		String time = (System.currentTimeMillis() - c)/1000.0f + " s";
		System.out.println(time);*/
    }
}

package threadDemo.demo3;

/**
 * 多窗口售票
 * @author wangzz-a
 * @version $Id: Ticket.java, v 0.1 2015年11月24日 下午2:14:43 wangzz-a Exp $
 */
public class Ticket implements Runnable {

	private static int tick = 100;
	
	Object obj = new Object();
	
	public void run(){
		while (true){
			synchronized (obj) {
				if(tick>0){
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}
					System.out.println(Thread.currentThread().getName()+"sale:"+tick--);
				}else{
					break;
				}
			}
		}
	}
}

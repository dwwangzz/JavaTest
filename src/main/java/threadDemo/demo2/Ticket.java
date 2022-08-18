package threadDemo.demo2;

/**
 * 多窗口售票
 * @author wangzz-a
 * @version $Id: Ticket.java, v 0.1 2015年11月24日 下午2:14:43 wangzz-a Exp $
 */
public class Ticket extends Thread {

	//构造函数
	public Ticket(String name) {
		super(name);
	}

	private static int tick = 100;

	@Override
	public void run(){
		while (true){
			if(tick>0){
				System.out.println(this.getName()+"sale:"+tick--);
			}else{
				break;
			}
		}
	}
}

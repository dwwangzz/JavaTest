package threadDemo.demo2;

public class Test {
	
	public static void main(String[] args) {
		Ticket t1 = new Ticket("刘亦菲");
		Ticket t2 = new Ticket("王水牛");
		Ticket t3 = new Ticket("李钢蛋");
		Ticket t4 = new Ticket("马大缸");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
}

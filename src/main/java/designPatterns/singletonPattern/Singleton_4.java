package designPatterns.singletonPattern;

/**
 * 4、双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @author wangzz
 * @date 2020年12月03日 17:08
 */
public class Singleton_4 {
	private volatile static Singleton_4 singleton;

	private Singleton_4() {
	}

	public static Singleton_4 getSingleton_4() {
		if (singleton == null) {
			synchronized (Singleton_4.class) {
				if (singleton == null) {
					singleton = new Singleton_4();
				}
			}
		}
		return singleton;
	}
}

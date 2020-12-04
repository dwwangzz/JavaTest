package designPatterns.abstractFactoryPattern;

/**
 * 绿色
 * @author wangzz
 * @date 2020年12月03日 16:48
 */

public class Green implements Color {
	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}
}

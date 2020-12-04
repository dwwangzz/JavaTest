package designPatterns.abstractFactoryPattern;

/**
 * 红色
 * @author wangzz
 * @date 2020年12月03日 16:48
 */

public class Red implements Color {
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}

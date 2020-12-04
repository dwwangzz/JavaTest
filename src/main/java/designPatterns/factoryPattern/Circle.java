package designPatterns.factoryPattern;

/**
 * 圆形
 * @author wangzz
 * @date 2020年12月03日 16:43
 */
public class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

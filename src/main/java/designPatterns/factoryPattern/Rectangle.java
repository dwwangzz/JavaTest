package designPatterns.factoryPattern;

/**
 * 长方形
 * @author wangzz
 * @date 2020年12月03日 16:41
 */
public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

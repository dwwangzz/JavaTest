package designPatterns.factoryPattern;

/**
 * 正方形
 * @author wangzz
 * @date 2020年12月03日 16:42
 */
public class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}

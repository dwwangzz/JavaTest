package designPatterns.abstractFactoryPattern;

/**
 * 工厂创造器/生成器类
 * @author wangzz
 * @date 2020年12月03日 16:56
 */
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}

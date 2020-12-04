package designPatterns.abstractFactoryPattern;

import designPatterns.factoryPattern.Shape;

/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 * @author wangzz
 * @date 2020年12月03日 16:50
 */
public abstract class AbstractFactory {

	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);

}

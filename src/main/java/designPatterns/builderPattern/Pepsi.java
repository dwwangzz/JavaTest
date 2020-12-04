package designPatterns.builderPattern;

/**
 * 百事可乐
 * @author wangzz
 * @date 2020年12月04日 10:53
 */

public class Pepsi extends ColdDrink{
	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 35.0f;
	}
}

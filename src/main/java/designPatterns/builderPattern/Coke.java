package designPatterns.builderPattern;

/**
 * 可口可乐
 * @author wangzz
 * @date 2020年12月04日 10:53
 */

public class Coke extends ColdDrink {
	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 30.0f;
	}
}

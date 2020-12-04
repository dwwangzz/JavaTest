package designPatterns.builderPattern;

/**
 * 炸鸡汉堡
 * @author wangzz
 * @date 2020年12月04日 10:52
 */

public class ChickenBurger extends Burger {
	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 50.5f;
	}
}

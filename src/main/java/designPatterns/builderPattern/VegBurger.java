package designPatterns.builderPattern;

/**
 * 蔬菜汉堡
 * @author wangzz
 * @date 2020年12月04日 10:51
 */

public class VegBurger extends Burger {
	@Override
	public String name() {
		return "Veg Burger";
	}

	@Override
	public float price() {
		return 25.0f;
	}
}

package designPatterns.builderPattern;

/**
 * 冷饮
 * @author wangzz
 * @date 2020年12月04日 10:50
 */

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}

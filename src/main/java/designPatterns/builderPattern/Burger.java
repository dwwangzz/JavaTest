package designPatterns.builderPattern;

/**
 * 汉堡
 * @author wangzz
 * @date 2020年12月04日 10:50
 */

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();

}

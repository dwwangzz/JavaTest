package designPatterns.builderPattern;

/**
 * 瓶子打包
 * @author wangzz
 * @date 2020年12月04日 10:49
 */

public class Bottle implements Packing {
	@Override
	public String pack() {
		return "Bottle";
	}
}

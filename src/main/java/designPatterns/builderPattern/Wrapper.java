package designPatterns.builderPattern;

/**
 * 包装打包
 * @author wangzz
 * @date 2020年12月04日 10:47
 */

public class Wrapper implements Packing {
	@Override
	public String pack() {
		return "Wrapper";
	}

}

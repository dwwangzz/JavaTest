package designPatterns.builderPattern;

/**
 * 1. 创建一个表示食物条目和食物包装的接口。
 * @author wangzz
 * @date 2020年12月04日 10:46
 */
public interface Item {

	public String name();

	public Packing packing();

	public float price();

}

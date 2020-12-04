package designPatterns.builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 餐，一顿饭
 * @author wangzz
 * @date 2020年12月04日 10:54
 */

public class Meal {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCost() {
		float cost = 0.0f;
		for (Item item : items) {
			cost += item.price();
		}
		return cost;
	}

	public void showItems() {
		for (Item item : items) {
			System.out.println("Item : " + item.name());
			System.out.println(", Packing : " + item.packing().pack());
			System.out.println(", Price : " + item.price());
		}
	}

}

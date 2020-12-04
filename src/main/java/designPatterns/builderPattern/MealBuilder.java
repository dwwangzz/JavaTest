package designPatterns.builderPattern;

/**
 * 生产套餐
 * MealBuilder
 * @author wangzz
 * @date 2020年12月04日 10:59
 */

public class MealBuilder {

	/**
	 * 蔬菜套餐：蔬菜汉堡 + 可口可乐
	 * @return
	 */
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	/**
	 * 非蔬菜套餐：炸鸡汉堡 + 百世可乐
	 * @return
	 */
	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}

}

package EnumTest.demo2;

/**
 * Created by wangzz on 2016/8/17.
 */
public class Car {

    public Car(Color color) {
        this.color = color;
    }

    private Color color;

    private String name;

    private double price;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

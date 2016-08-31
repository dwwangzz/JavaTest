package SerializableDemo;

import java.io.Serializable;

public class Foo implements Serializable{
	
	/** 
	 * @Fields serialVersionUID : Foo类的序列化id
	 */ 
	private static final long serialVersionUID = 7059021422759428079L;

	private int width;
	
	private int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Foo [width=" + width + ", height=" + height + "]";
	}
}

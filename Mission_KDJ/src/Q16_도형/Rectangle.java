package Q16_도형;
/**
 * 아래의 <조건>에 따라 Rectangle 클래스를 작성하시오.

	<조건>
	
	- Shape 클래스를 구현하시오.
	- 멤버변수로 가로, 높이 길이를 저장할 변수를 선언하시오.
	- 생성자를 정의하시오.
	- getter, setter 메소드를 정의하시오.
	- toString() 메소드를 재정의하시오.
 */
public class Rectangle extends Shape{
	
	// 멤버 변수 -  가로, 높이
	double width,height;
	
	
	//생성자
	public Rectangle() { // 기본생성자
		this(0.0,0.0);
	}

	public Rectangle(double width, double height) { // 매개변수를 갖는 생성자
		this.width = width;
		this.height = height;
	}
	
	// 넓이 구하는 메소드
	@Override
	double area() {
		return width * height;
	}
	// 둘레 구하는 메소드
	@Override
	double round() {
		return (width * 2) + (height * 2);
	}
	
	
	// getter,setter
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// toString
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
}

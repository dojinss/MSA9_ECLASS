package Q16_도형;
/**
 * 아래의 <조건>에 따라 Circle 클래스를 작성하시오.

	<조건>
	
	- Shape 클래스를 구현하시오.
	- 멤버변수로 반지름 길이를 저장할 변수를 선언하시오.
	- 생성자를 정의하시오.
	- getter, setter 메소드를 정의하시오.
	- toString() 메소드를 재정의하시오.
 */
public class Circle extends Shape{	// Shape 클래스를 extends 하여 구현
	
	// 매개 변수 - 반지름
	double radius;
	
	// 생성자
	public Circle() { // 기본생성자
		this(0);
	}

	public Circle(double radius) { // 매개변수를 갖는 생성자
		this.radius = radius;
	}
	
	
	// 넓이 구하는 메소드
	@Override
	double area() {
		// 원의 넓이 원주율 * 반지름의 제곱
		return Math.PI * Math.pow(radius, 2);
	}
	// 둘래 구하는 메소드
	@Override
	double round() {
		// 원의 둘래 ( 2 * 원주율 * 반지름 )
		return 2 * Math.PI * radius;
	}
	
	// getter,setter
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// toString
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	
}

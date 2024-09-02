package Q16_도형;
/**
 * 아래의 <조건>에 따라 Shape 클래스를 작성하시오.

	<조건>
	
	- 추상 클래스로 정의하시오.
	- 멤버변수로 Point 객체를 선언하시오.
	- 넓이( area( ) )와 둘레( round( ) )를 구하는 메소드 원형을 정의하시오.
	- getter, setter 메소드를 정의하시오.
 */
public abstract class Shape {
	// Point 객체
	Point point;
	
	// 추상 메소드
	abstract double area();
	abstract double round();
	
	// Point 객체 getter,setter
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	};
	
}

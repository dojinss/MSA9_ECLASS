package Q16_도형;
/**
 * 아래의 <조건>에 따라 Point 클래스를 작성하시오.

	<조건>
	
	- 멤버변수로 정수형 변수 x, y 를 선언하시오.
	- 기본생성자와 x, y를 매개변수로 갖는 생성자를 정의하시오.
	- toString() 메소드를 재정의하시오.
 */

public class Point {
	
	// 멤버 변수 - 정수형 x,y
	private int x;
	private int y;
	
	// 생성자
	public Point() { // 기본 생성자
	}
	public Point(int x, int y) { // 매개변수를 갖는 생성자
		this.x = x;
		this.y = y;
	}
	
	// toString
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

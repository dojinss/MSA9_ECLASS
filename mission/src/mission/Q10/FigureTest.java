package mission.Q10;
/**
 * 아래의 주어진 코드를 실행 시켰을 때, 출력 예시와 같은 결과가 나오도록 
 * [Triangle.java, Rectangle.java, Circle.java,Trapezoid.java] 클래스를 정의하시오.
 * <조건>
	- 아래의 클래스 다이어그램을 참고하여 멤버변수, 생성자, 메소드를 정의하시오.
	
	[Triangle]
	
	double width
	double height
	Triangle( )
	Triangle( width, height)
	getArea( )
	toString( )
	
	[Rectangle]
	
	double width
	double height
	Rectangle( )
	Rectangle( width, height)
	getArea( )
	toString( )
	
	[Circle]
	
	double radius
	Rectangle( )
	Rectangle( radius )
	getArea( )
	toString( )
	
	[Trapezoid]
	
	double top
	double bottom
	double height
	Rectangle( )
	Rectangle( top, bottom, height)
	getArea( )
	toString( )
 */
public class FigureTest {

	public static void main(String[] args) {

		Triangle triangle = new Triangle(10, 20);
		Rectangle ractangle = new Rectangle(10, 20);
		Circle circle = new Circle(5);
		Trapezoid trapezoid = new Trapezoid(5, 10, 8);
		System.out.println("삼각형의 넓이 : " + triangle.getArea());
		System.out.println("사각형의 넓이 : " + ractangle.getArea());
		System.out.println("원형의 넓이 : " + circle.getArea());
		System.out.println("사다리꼴의 넓이 : " + trapezoid.getArea());
	
	}

}
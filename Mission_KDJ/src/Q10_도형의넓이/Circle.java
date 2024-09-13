package Q10_도형의넓이;

public class Circle {
	
	// 멤버 변수
	double radius;

	// 생성자

	public Circle() {
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// 메소드
	public double getArea(){
		double area = Math.PI * Math.pow(this.radius, 2); 
		return area;
	}

	// toString
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	
}

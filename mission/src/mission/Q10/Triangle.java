package mission.Q10;

public class Triangle {
	
	// 멤버 변수
	double width;
	double height;
	
	// 생성자
	public Triangle() {
		
	}
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// 메소드
	public double getArea() {
		double area = (this.width * this.height) / 2;
		return area;
	}

	// toString
	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + "]";
	}
	
	
	
	
}
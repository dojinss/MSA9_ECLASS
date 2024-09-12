package mission.Q10;

public class Rectangle {
	
	// 멤버 변수
	double width;
	double height;

	// 생성자
	public Rectangle() {}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// 메소드
	public double getArea() {
		double area = this.width * this.height;
		return area;
	}

	// toString
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
}
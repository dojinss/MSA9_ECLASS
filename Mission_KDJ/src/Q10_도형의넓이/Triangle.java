package Q10_도형의넓이;

public class Triangle {
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
	public double getArea(double width, double height) {
		double area = (width * height) / 2;
		return area;
	}

	// toString
	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + "]";
	}
	
	
	
	
}

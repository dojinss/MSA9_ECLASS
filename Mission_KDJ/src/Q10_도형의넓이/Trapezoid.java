package Q10_도형의넓이;

public class Trapezoid {
	
	// 멤버 변수
	double top;
	double bottom;
	double height;
	
	// 생성자
	@Override
	public String toString() {
		return "Trapezoid []";
	}

	public Trapezoid(double top, double bottom, double height) {
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}
	
	// 메소드
	public double getArea() {
		double area = ((this.top + this.bottom) / 2) * this.height ;
		return area;
	}
	
}

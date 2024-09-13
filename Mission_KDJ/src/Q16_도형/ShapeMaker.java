package Q16_도형;
/**
 * 아래의 <조건>에 따라 ShapeMaker 클래스를 작성하시오.

	<조건>
	
	- main() 메소드를 정의 하시오.
	- 1. 삼각형, 2. 사각형, 3. 원형 으로 각 도형의 종류를 선택하시오.
	- 선택된 도형에 따라 필요한 변수를 입력 받아 객체를 생성하시오.
	- 여러 개의 도형 객체를 입력 받아, 리스트에 추가하시오.
	- “그만"을 입력하면, 리스트에 존재하는 도형들의 둘레와 넓이를 출력하시오.
	- 마지막으로, 도형들의 둘레 총합과 넓이 총합을 출력하시오.
 */
import java.util.Scanner;

public class ShapeMaker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 변수
		double width	= 0.0;
		double height	= 0.0;
		double radius	= 0.0;
		
		// 입력받은 도형 배열
		Shape[] shapeList = new Shape[10];
		int index = 0;
		
		while(true) {
			if(index == 10) break;
			
			System.out.println("1. 삼각형, 2. 사각형, 3. 원형");
			System.out.print(">>");
			String input = sc.next();
			
			if ( input.equals("그만")) {
				break;
			}
			switch (input) {
				case "1":
					System.out.println("가로 : ");
					width = sc.nextDouble();
					System.out.println("세로 : ");
					height = sc.nextDouble();
					shapeList[index++] = new Triangle(width,height);
					break;
				case "2":
					System.out.println("가로 : ");
					width = sc.nextDouble();
					System.out.println("세로 : ");
					height = sc.nextDouble();
					shapeList[index++] = new Rectangle(width,height);
					break;
				case "3" :
					System.out.print("반지름 :");
					radius = sc.nextDouble();
					shapeList[index++] = new Circle(radius);
					break;
			}
		}
		
		// 넓이 총합, 둘래 총합
		double areaSum = 0.0;
		double roundSum = 0.0;
		
		for (Shape shape : shapeList) {
			
			if( shape == null ) continue;
			
			double area = shape.area();
			double round = shape.round();
			
			areaSum += area;
			roundSum += round;
			
			// instanceof : 인스턴스를 비교(확인)하는 연산
			// - 같은 인스턴스면 true, 아니면 false 를 반환
			if( shape instanceof Triangle ) System.out.println("삼각형");
			if( shape instanceof Rectangle ) System.out.println("사각형");
			if( shape instanceof Circle ) System.out.println("원형");
			
			System.out.printf("넓이 : %.3f \t",area);
			System.out.printf("둘래 : %.3f \t",round);
			System.out.println();
		}
		
		System.out.printf("넓이의 총합 : %.2f \n",areaSum);
		System.out.printf("둘래의 총합  : %.2f \n",roundSum);
		
		
		sc.close();
	}
}

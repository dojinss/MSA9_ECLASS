package Q05_치킨메뉴판;

import java.util.Scanner;

/**
 * (조건)
 * do~while 문, switch 문, static 메소드 정의 및 호출을 반드시 사용하시오.
 * 정수1~3 입력 시, 해당 메뉴 이름과 주문안내 문구를 출력하시오.
 * 정수 0~3 이외의 번호를 입력하면, 0~3 사이의 번호를 입력하도록 요청하는 안내문구를 출력하시오.
 * 정수 0 입력 시, 주문한 메뉴 개수와 주문완료 메시지를 출력하시오.
 */
public class Main {
	
	static String menu1	= "1. 황금올리브 프라이드 치킨";		// 1번 메뉴
	static String menu2	= "2. 옛날 양념 통닭";				// 2번 메뉴
	static String menu3	= "3. 반반 무 많이 치킨";			// 3번 메뉴
	
	
	static void callList() {

		System.out.println("::::::: 치킨 메뉴판 :::::::");
		System.out.println(menu1);
		System.out.println(menu2);
		System.out.println(menu3);
		System.out.println("0. 주문 끝내기");
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuCount 	= 0;			// 총 주문 개수
		int count1		= 0;			// 1번 메뉴 주문 개수
		int count2		= 0;			// 2번 메뉴 주문 개수
		int count3		= 0;			// 3번 메뉴 주문 개수
		
		do {
			callList();
			System.out.print("번호를 선택하세요 : ");
			int input = sc.nextInt();
			sc.nextLine();
			
			if(input == 0) {
				
				System.out.println(":::::::::::::::::::::::::::::::::::::");
				
				System.out.println(menu1 + " : " + count1 + "개");
				System.out.println(menu2 + " : " + count2 + "개");
				System.out.println(menu3 + " : " + count3 + "개");
				
				menuCount = count1 + count2 + count3;
				String comMsg = "\t\t총 주문건수 : " + menuCount + " \n\t\t주문을 완료합니다.";
				System.out.println(comMsg);
				
				System.out.println(":::::::::::::::::::::::::::::::::::::");
				break;
			}
			else if( input > 3 || input < 0 ){
				System.err.println("0 ~ 3 사이 숫자만 입력 가능합니다!");
				continue;
			}			
			switch (input) {
				case 1:
					System.out.println(menu1 + "(을/를) 1개 주문 하셨습니다.");
					count1++;
					break;
				case 2:
					System.out.println(menu2 + "(을/를) 1개 주문 하셨습니다.");
					count2++;
					break;
				case 3:
					System.out.println(menu3 + "(을/를) 1개 주문 하셨습니다.");
					count3++;
					break;
			}
			
		} while (true);
		sc.close();
	}
}

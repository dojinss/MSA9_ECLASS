package mission.Q02;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();					//정수a 입력
		int sum = 0;							//정수 sum 초기화
		int sum2 = 0; 							//정수 sum2 초기화

		//홀수를 입력했을 경우
		if(a%2 == 1) {							//a가 홀수일 때
			//홀수 1~a에 대한 수식 및 합계
			for (int i = 1; i <= a; i++) {		//i를 1부터 입력값 a까지 반복
				if(i%2 == 1 && i != a) {		//i가 홀수이고 i가 a(마지막 값)이 아닐때
					System.out.print(i + "+");	//i+ 출력
					sum += i;					//sum = sum + i;
				}
				if(i==a) {						//i가 a(마지막 값)과 같을 때
					System.out.print(i);		//i 출력
					sum = sum + a;				//위 마지막 sum과 a를 더함
				}
			}
			System.out.println("="+sum);		//=sum 출력
			//짝수 1~a에 대한 수식 및 합계
			for (int i = 1; i <= a; i++) {		//i를 1부터 입력값 a까지 반복
				if(i%2 == 0 && i != a-1) {		//a를 홀수로 입력한 경우기 때문에 i가 짝수이고 a-1과 같지 않을 때
					System.out.print(i + "+");	//i+ 출력
					sum2 += i;					//sum2 = sum2 + i;
				}
				if(i==a-1) {					//i가 a-1 ex) 9입력 경우 8일 때
					System.out.print(i);		//i 출력
					sum2 = sum2 + i;			//sum2의 마지막 값과 i 마지막 값 합산
				}
			}
			System.out.println("="+sum2);		//=sum2 출력
		}
		
		//짝수를 입력했을 경우
		else {
			//홀수 1~a에 대한 수식 및 합계
			for (int i = 1; i <= a; i++) {
				if(i%2 == 1 && i < a-1) {
					System.out.print(i + "+");
					sum += i;
				}
				if(i==a-1) {
					System.out.print(i);
					sum = sum + i;
				}
			}
			System.out.println("="+sum);
			//짝수 1~a에 대한 수식 및 합계
			for (int i = 1; i <= a; i++) {
				if(i%2 == 0 && i != a) {
					System.out.print(i + "+");
					sum2 += i;
				}
				if(i==a) {
					System.out.print(i);
					sum2 = sum2 + a;
				}
			}
			System.out.println("="+sum2);
		}
		//약수
		for (int i = 1; i <= a; i++) {
			if(a%i == 0) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}
}

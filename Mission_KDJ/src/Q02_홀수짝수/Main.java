package Q02_홀수짝수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();			// 입력숫자
		int sum1 = 0;						// 홀수합
		int sum2 = 0;						// 짝수합
		boolean check = input % 2 == 0;		// 입력값 짝수인지 홀수인지 체크
		
		// 홀수 합
		for (int i = 1; i <= input; i++) {
			if(i == input && !check) {			// 마지막 숫자이면서 짝수가 아닐때(홀수일때) = 마지막 숫자가 홀수일때
				System.out.print(i + " = " + (sum1+i));
				break;
			}
			else if(i == input - 1 && check) {	// 마지막 숫자가 짝수일때 -1 하여 마지막 홀수일경우 실행
				System.out.print(i + " = " + (sum1+i));
				break;
			}
			if(i % 2 == 1) {
				System.out.print(i + " + ");
				sum1 += i;						// 합계변수에 숫자더하기
			}
		}
		System.out.println();
		// 짝수 합
		for (int i = 1; i <= input; i++) {
			if(i == input && check) {			// 마지막 숫자가 짝수일때
				// 마지막 출력값 " = 합계 " 이기때문에 
				System.out.print(i + " = " + (sum2+i));	
				break;
			}
			else if(i == input - 1 && !check) {	// 마지막 숫자가 홀수일경우 짝수합 마지막 실행 하기 위해 입력값 - 1 값 확인
				System.out.print(i + " = " + (sum2+i));
				break;
			}
			if(i % 2 == 0) {
				System.out.print(i + " + ");
				sum2 += i;						// 합계변수에 숫자더하기
			}
		}
		System.out.println();
		
		// 약수
		for (int i = 1; i <= input; i++) {
			if(input % i == 0)	System.out.print(i + " ");	// 나머지가 0이면 약수
		}
		System.out.println();
		
		sc.close();
	}
}

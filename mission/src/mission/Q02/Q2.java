package mission.Q02;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int sum = 0;
		int sum2 = 0; 
		//홀수를 입력했을 경우
		if(a%2 == 1) {
			//홀수 1~a에 대한 수식 및 합계
			for (int i = 1; i <= a; i++) {
				if(i%2 == 1 && i != a) {
					System.out.print(i + "+");
					sum += i;
				}
				if(i==a) {
					System.out.print(i);
					sum = sum + a;
				}
			}
			System.out.println("="+sum);
			//짝수 1~a에 대한 수식 및 합계
			for (int i = 1; i <= a; i++) {
				if(i%2 == 0 && i != a-1) {
					System.out.print(i + "+");
					sum2 += i;
				}
				if(i==a-1) {
					System.out.print(i);
					sum2 = sum2 + i;
				}
			}
			System.out.println("="+sum2);
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

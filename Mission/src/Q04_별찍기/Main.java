package Q04_별찍기;

import java.util.Scanner;
/**
 * 	N개의 양수 입력
 *  N개의 줄
 *  
 *  별 개수 증가량 (줄번호 * 2) -1
 *  
 *  빈공간 (N-(줄번호)) ~ 1
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		for (int i = 1; i <= input; i++) {
			// 빈공간 출력
			for (int j = (input - i); j > 0; j--) {
				System.out.print(" ");
			}
			// 별 출력
			for (int j = 1; j <= ((i * 2) - 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

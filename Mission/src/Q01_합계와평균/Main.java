package Q01_합계와평균;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int engSco = 0;
		int mathSco = 0;
		int javaSco = 0;
		
		int totalScore = 0;
		double avgScore = 0.0;
		
		// 점수 입력
		Scanner sc = new Scanner(System.in);
		engSco = sc.nextInt();
		mathSco = sc.nextInt();
		javaSco = sc.nextInt();
		sc.nextLine();
		
		// 3과목 점수
		System.out.println("영어 점수 : " + engSco);
		System.out.println("수학 점수 : " + mathSco);
		System.out.println("자바 점수 : " + javaSco);
		// 합계
		totalScore = (engSco + mathSco + javaSco);
		System.out.println("합계 : " + totalScore);
		
		// 평균
		avgScore = (totalScore/3);
		System.out.println("평균 : "  + avgScore);
		sc.close();
	}
}

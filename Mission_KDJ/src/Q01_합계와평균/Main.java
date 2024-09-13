package Q01_합계와평균;

import java.util.Scanner;

/**
 * 	학생의 영어, 수학, 자바 성적을 각각 정수형 변수 eng, math, java 로 선언하고, 
 * 	순서대로 점수를 입력 받아 성적의 총 합계와 평균을 계산하여 출력하는 프로그램을 작성하시오.
 */

public class Main {
	public static void main(String[] args) {
		int engSco = 0;			// 영어점수
		int mathSco = 0;		// 수학점수
		int javaSco = 0;		// 자바점수
		
		int totalScore = 0;		// 점수 합계
		double avgScore = 0.0;	// 평균
		
		// 점수 입력
		Scanner sc = new Scanner(System.in);
		engSco = sc.nextInt();		// 영어점수 입력
		mathSco = sc.nextInt();		// 수학점수 입력
		javaSco = sc.nextInt();		// 자바점수 입력
		sc.nextLine();				// 엔터키 초기화
		
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

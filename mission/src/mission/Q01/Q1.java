package mission.Q01;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int eng = sc.nextInt();
		int math = sc.nextInt();
		int java = sc.nextInt();
		
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("자바 점수 : " + java);
		System.out.println("총점 : " + (eng+math+java));
		System.out.println("평균 : " + (eng+math+java)/3.0);
		
		sc.close();
	}
}

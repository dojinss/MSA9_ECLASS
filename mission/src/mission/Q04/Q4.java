package mission.Q04;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			System.out.println("*");
			for (int j = 1; j <= i+(i-1); j++) {
				System.out.print("*");
			}
		}
		
		sc.close();
	}
}

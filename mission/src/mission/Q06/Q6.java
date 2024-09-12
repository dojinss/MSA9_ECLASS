package mission.Q06;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임?");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
				System.out.print("[" + (i+1) + "게임]");
				int lotto[] = new int[6];
				
			for (int j = 0; j < lotto.length; j++) {
				int rand = (int)(Math.random() * 45 + 1);
				lotto[j] = rand;
				
				for (int k = 0; k < j; k++) {
					if(rand == lotto[k]) {
						j--;
						break;
					}
				}
			}
			
			for (int j = 0; j < lotto.length; j++) {
				for (int k = j+1; k < lotto.length; k++) {
					//앞에 요소가 더 크면 교환 - swap
					if(lotto[j] > lotto[k]) {
						int temp = lotto[j];
						lotto[j] = lotto[k];
						lotto[k] = temp;
					}
				}
			}
			
			//출력
			for (int j = 0; j < lotto.length; j++) {
				System.out.print(lotto[j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

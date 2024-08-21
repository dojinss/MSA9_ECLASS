package Q06_로또리아;

import java.util.Scanner;

/**
 *	정수 N을 입력받아 N개의 게임의 로또 번호를 출력하시오.
 *	즉, 6개의 배열요소를 갖는 1차원 배열을 선언하여 1~45 사이의 랜덤한 값을 중복되지 않도록 저장하고 출력하는 과정을
 *	N번 반복하시오.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("총 게임수 입력 : ");
		int N = sc.nextInt();									// 정수 N 입력
		sc.nextLine();											// 엔터키 초기화
		
		for (int i = 0; i < N; i++) {							// N번만큼 반복
			int arr[] = new int[6];								// 배열 선언
			for (int j = 0; j < arr.length; j++) {				// 배열 개수만큼 반복
				int rnd = (int)(Math.random() * 45 + 1); 		// (int)(Math.random() * 끝수 + 시작수
				arr[j] = rnd;
				for (int k = 0; k < j; k++) {					// 배열반복문(j) 부터 0 까지 반복하여 중복확인
					if(arr[k] == arr[j]) {						// 같은수가 있을경우 배열반복(j)감소하여 다시 수행
						j--;
					}
				}
			}
			
			for (int j = 0; j < arr.length; j++) {				// 오름차순 정렬 (선택 정렬)
				for (int k = j+1;  k < arr.length; k++) {
					if(arr[k] < arr[j]) {
						int temp = arr[k];
						arr[k] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.print("[" + (i+1) + " 게임] : ");
			for (int j : arr) {
				if(j < 10 ) System.out.print(" ");				// 1의자리수일경우 공백추가
				System.out.print( j + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

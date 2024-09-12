package mission.Q08;

import java.util.Scanner;

/**
 *	정수 N을 입력 받아, N행 N열의 2차원 배열을 선언하시오. 그리고 배열요소의 1부터 1씩 증가하는 값을 
 *	순서대로 저장하 면서 1 행이 증가할 때마다 배열요소에 접근하는 방향을 반대로 하여 값을 저장하고 출력하시오.
 */
public class Q8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N 			= sc.nextInt();					// 정수 N 입력
		int arr[][] 	= new int[N][N];				// N행N열 2차원 배열 생성
		boolean	check	= true;							// 정방향 역방향 판별
		
		for (int i = 0; i < arr.length; i++) {
			// 정방향
			if(check) {
				// 행 * 열 ~ 다음행(행+1) * 열 까지
				for (int j = (i * N) + 1; j <= (i + 1) * N ; j++) {
					if(j < 10) System.out.print(" ");	// 1의자리수 앞에 빈칸출력
					
					// 10의자리 수입력할경우(출력숫자가 100의자리가 있을경우) 1의자리 10의 자리에 빈칸 추가
					if(j < 100 && 99 < (N*N) && j != N*N) System.out.print(" ");	
					System.out.print(j + " ");			
				}
				check = !check;
			}
			// 역방향
			else {
				for (int j = (i + 1) * N; j >= (i * N) + 1; j--) {
					if(j < 10) System.out.print(" ");					// 1의자리수 앞에 빈칸출력
	
					// 10의자리 수입력할경우(출력숫자가 100의자리가 있을경우) 1의자리 10의 자리에 빈칸 추가
					if(j < 100 && 99 < (N*N) && j != N*N) System.out.print(" ");	
					
					System.out.print(j + " ");			
				}	
				check = !check;
			}
			System.out.println();
		}
		
		sc.close();
	}
}
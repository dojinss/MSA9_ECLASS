package Q07_성적정렬하기;

import java.util.Scanner;

/**
 * 	학생 5명의 JAVA 프로그래밍 성적을 입력 받아, 1차원 배열에 저장하고 성적을 기준으로 오름차순, 
 * 	내림차순으로 각각 출력하시오.
 *	(단, 정렬 방식은 선택정렬, 버블정렬, 삽입정렬 중 하나의 정렬 방식을 이용하시오. 
 *  성적은 정수 0이상 100이하로 주어집니다.)
 *
 *	• (조건)
 *		JAVA API에서 제공되는 메소드는 이용하지 않는다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int scoArr[] = new int[5];					// 학생 5명 성정입력받을 배열선언
		for (int i = 0; i < scoArr.length; i++) {
			scoArr[i] = sc.nextInt();				// 점수 입력
		}
		sc.nextLine();
		System.out.println();
		
		// 오름차순 정렬 (삽입 정렬)
		// 2번째부터 바로 전단계와 비교하며 0번째까지 비교, 키값보다 큰수는 뒤로 밀어내고 자리를 찾아감
		for (int i = 2; i < scoArr.length; i++) { 	// 2번째 부터시작	
			for (int j = i; j > 0; j--) {			// 앞에 배열요소들 만큼 index[1]까지 반복
				if(scoArr[j] < scoArr[j-1]) {		// 바로 전단계 인덱스와 크기 비교 하여 자리바꿈
					int temp = scoArr[j-1];
					scoArr[j-1] = scoArr[j];
					scoArr[j] = temp;
				}
			}
		}
		
		for (int i : scoArr) {
			System.out.print(i + " ");
		}
		
		sc.close();
	}
}

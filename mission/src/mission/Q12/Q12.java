package mission.Q12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임?");
		int N = sc.nextInt();	//정수 N 입력
		for (int i = 0; i <= N-1; i++) {	//i를 0부터 N-1까지 인덱스를 반복
			System.out.print("[" + (i+1) + "게임] ");
			ArrayList<Integer> lottoList = new ArrayList<Integer>();	//lottoList 정수 객체 생성
			for (int j = 0; j < 6; j++) {	//j를 6 미만까지 반복
				int rand = (int)(Math.random() * 45 + 1); //난수를 45까지 반복 0부터이므로 +1
				//중복제거
				if(lottoList.contains(rand)) j--;	//lottoList에 중복된 숫자가 나오면 j감소로 다시 뽑기
				else lottoList.add(rand);	//아니라면 숫자 추가
			}
			//정렬
			Collections.sort(lottoList);	//lottoList를 오름차순으로 정렬
			
			//출력
			for (Integer lotto : lottoList) {
				System.out.print(lotto + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}

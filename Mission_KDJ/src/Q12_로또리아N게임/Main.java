package Q12_로또리아N게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * 	정수 N을 입력받아 N개의 게임의 로또 번호를 출력하시오.
 *	ArrayList를 선언하여 1~45 사이의 랜덤한 값을 
 *	중복되지 않도록 저장하고 출력하는 과정을 N번 반복하시오.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임?");
		int input = sc.nextInt();			// 입력값 N
		sc.nextLine();						// 엔터키 해제
		
		
		for (int i = 1; i <= input; i++) {	// N번만큼 반복
			System.out.print("["+i+"게임] : ");
			// ArrayList 선언
			// 정수 1~45사이 숫자를 담기위해 Integer 형으로 선언
			List<Integer> lottoList = new ArrayList<Integer>();	
			for (int j = 0; j < 6; j++) {	// 로또 번호 6개 생성
				int rnd = new Random().nextInt(45)+1;	// 1 ~ 45 사이 난수 생성
				boolean check = true;					// 중복 체크 불타입 생성
				for (int item : lottoList) {			// 존재하는 로또 번호 만큼 반복
					if(item == rnd) check = false;		// 중복 될경우 false값 반환
				}
				if(check) {								// 중복이 아닐경우 삽입
					lottoList.add(rnd);
				}
				else{									// 중복일경우 j-- 하여 다시 반복
					j--;
				}
			}
			Collections.sort(lottoList);				// Collections 의 정렬 메소드 sort()사용 오름차순
			for (int item : lottoList) {
				if(item <10) System.out.print(" ");		// 1의 자리 수 일경우 빈칸 출력
				System.out.print(item +" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

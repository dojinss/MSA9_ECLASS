package Q03_369게임;

public class Main {
	public static void main(String[] args) {
		
		int start = 1;		// 시작값
		int end = 100;		// 마지막값
		
		// 첫번째
		System.out.println(":::::::::::::::: 1번 ::::::::::::::::");
		int[] checkNum = {3,6,9};			// 체크할 숫자들
		boolean check = true;				// 숫자인지 별인지 체크
		for (int i = start; i <= end; i++) {
			check = true;					// 기본적으로 번호 출력할수있게 check값 초기화
			
			// 숫자를 10으로 나눈 나머지값일경우 1의 자리수 -> 3,6,9 일경우 별
			// 숫자를 10으로 나눈경우 int 자료형 특성으로 인해 반내림 정수 값 -> 3,6,9 일경우 별
			// 별을 출력할 경우 숫자 출력하면 안되기에 check 값 false
			for (int j = 0; j < checkNum.length; j++) {
				if( i % 10 == checkNum[j])	{check = false;System.out.print("*");}
				if( i / 10 == checkNum[j])	{check = false;System.out.print("*");}
			}
			if(check) 	System.out.print(i);				// 3,6,9가아니면 숫자출력
			else 		System.out.print("\t["+i+"]");		// 3,6,9일경우 [확인용] 숫자출력
			System.out.println();
		}
		
		
		
		// 두번째
		System.out.println(":::::::::::::::: 2번 ::::::::::::::::");
		for (int i = start; i <= end; i++) {
			int checkNum1 = i % 10;		// 숫자를 10으로 나눈 나머지값 -> 1의자리수
			int checkNum10 = i / 10;	// 숫자를 10으로 나눈 값 int자료형 특성으로 반내림 -> 10의 자리수
			boolean numCheck = true;	// 숫자인지 아닌지 체크

			boolean check3	 = false;	// 1의 자리수 3인지 체크한 값을 담는 변수
			boolean check6	 = false;	// 1의 자리수 6인지 체크한 값을 담는 변수
			boolean check9	 = false;	// 1의 자리수 9인지 체크한 값을 담는 변수
			
			boolean check30	 = false;	// 10의 자리수 3인지 체크한 값을 담는 변수
			boolean check60	 = false;	// 10의 자리수 6인지 체크한 값을 담는 변수
			boolean check90	 = false;	// 10의 자리수 9인지 체크한 값을 담는 변수
			
			check3 = checkNum1 % 3 == 0 && checkNum1 != 0;	// 1의 자리수 3인지 체크
			check6 = checkNum1 % 6 == 0 && checkNum1 != 0;	// 1의 자리수 6인지 체크
			check9 = checkNum1 % 9 == 0 && checkNum1 != 0;	// 1의 자리수 9인지 체크
			if(check3 || check6 || check9) {				// 위 3가지 하나라도 해당하면 별출력
				System.out.print("*");
				numCheck = false;							// 별출력하면 숫자체크 false
			}
			if(i > 10) {									// 10의 자리수 확인
				check30 = checkNum10 % 3 == 0;				// 10의 자리수 3인지 체크
				check60 = checkNum10 % 6 == 0;				// 10의 자리수 6인지 체크
				check90 = checkNum10 % 9 == 0;				// 10의 자리수 9인지 체크
				if(check30 || check60 || check90) {			// 위 3가지 하나라도 해당하면 별출력
					System.out.print("*");
					numCheck = false;						// 별출력하면 숫자체크 false
				}
			}
			
			if(numCheck)	System.out.print(i);			// 3,6,9가아니면 숫자출력
			else			System.out.print("\t["+i+"]");	// 3,6,9일경우 [확인용] 숫자출력
			
			System.out.println();
			
		}
		
	}
}

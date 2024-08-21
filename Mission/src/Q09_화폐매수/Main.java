package Q09_화폐매수;

import java.util.Scanner;

/**
 * 	다음의 <조건> 에 따라 화폐매수를 구하는 프로그램을 작성하시오.
 *	<조건>
 *	(1) 화폐는 고액권을 우선으로 지급, 나머지 금액은 그 다음 단위의 화폐 순서로 지급한다.
 *	(2) 화폐 단위는 50000원, 10000원 5000원, 1000원, 500원, 100원, 50원, 10원, 5원, 1원의 10가지 종류가 있다.
 *	(3) 입력데이터는 성명, 간식비 지급액이며, 성명의 입력이 "QUIT" 이면 입력의 끝으로 간주한다.
 *	(4) 출력은 성명, 간식비 지급액, 개인별 각 화폐 매수, 마지막에 전체 화폐 매수를 출력한다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = new String[10];				// 입력 이름 [최대입력 10]
		int[] coins = new int[10];						// 입력 금액
		int[] totalCoins = new int[10];					// 총 화폐별 매수
		for (int i = 0; i < totalCoins.length; i++) {	// totalCoins 배열 전부 0으로 초기화
			totalCoins[i] = 0;
		}
		
		int count = 0;
		
		// 입력 구간
		do {
			String input = new String(sc.nextLine());
			if(input.equalsIgnoreCase("QUIT")) break;		// QUIT 문자열 입력시 입력 종료
			String[] value = input.split(" ");				// 한줄을 입력받아 " " 빈칸으로 구분하여 이름과 금액으로 나눔
			names[count] = value[0];						// names배열에 이름 저장
			coins[count++] = Integer.parseInt( value[1] );	// coins배열에 String으로 입력받은 값을 int형으로 변환
		} while (true);
		
		
		// 출력 구간
		System.out.println("성명\t출장비\t오만원\t만원\t오천원\t천원\t오백원\t백원\t오십원\t십원\t오원\t일원");
		for (int i = 0; i < names.length; i++) {
			// quit 입력하여 배열이 가득 차기전에 종료하여 null값이 입력된경우 출력하지 않고 넘긴다.
			if(names[i] == null) continue;					
			
			System.out.print(names[i] + "\t");				// 이름출력
			System.out.print(coins[i] + "\t");				// 금액출력
			int totalMoney = coins[i];						// 초기 금액 저장
			int money = 50000;								// 5만원권부터 시작
			boolean check = true;							// 5와 2 판별 변수
			int moneyCount = 0;								// 화폐 매수 담을 변수
			count = 0;
			while(money >= 1) {
				moneyCount = totalMoney / money;			// 화폐 매수
				totalMoney = totalMoney % money;			// 현재 금액 (화폐 매수 만큼 뺀 나머지금액)
				totalCoins[count++] += moneyCount;			// 현재 화폐 총 매수 저장
				System.out.print(moneyCount + "\t");
				
				// 5와 2를 번갈아 가며 나누어주면 50 10 5 1 형태의 화폐 단위를 계산할수있다.
				if(check)	{ money = money / 5; check = !check;}
				else		{ money = money / 2; check = !check;}
				
			}
			System.out.println();
		}
		
		// 총 화폐별 매수 출력
		System.out.print("전체 화폐 매수 :\t");
		for (int a : totalCoins) {
			System.out.print(a + "\t");
			
		}
		System.out.println();
		sc.close();
	}
}

package mission.Q13;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 	‘김조은’씨는 로또 판매점에 가서 로또를 구매합니다. 로또는 한 장에 최대 5개의 게임을 선택할 수 있으며, 
 * 	(자동), (수동) 방식으로 1~45 사이의 숫자 중에서 6개의 번호를 지정할 수 있습니다. 
 * 	<실행결과>와 같이 구매한 로또 용지를 출력하고 당첨결과도 확인할 수 있는 프로그램을 작성해보세요.
		
	<조건>
	
	- ArrayList 를 이용하시오
	- 싱글톤 패턴을 적용하시오.
	- 발행일은 현재 시간으로 지정하며 추첨일은 토요일 오후 9시를 기준으로,
	
	이전이면 그 주 토요일 9시로 이후이면 차주 토요일 오후 9시로 지정하시오.
	
	- 지급기한은 1년하고 1일을 더한 날짜로 지정하시오.
	
	- 당첨 등수는 당첨번호와 게임당 선택번호가 일치하는 개수로 정한다.
	
	6개 일치하면 1등,
	5개 일치하고 보너스 번호가 일치하면 2등,
	5개만 일치하면 3등,
	4개 일치하면 4등,
	3개 일치하면 5등
 * 
 */



public class Main {
	private final static int MAX_GAME = 5;											// 최대 게임수 5
	static Scanner sc = new Scanner(System.in);										// 입력 객체 선언
	private static Lottos[] totalList = new Lottos[MAX_GAME];						// Lottos클래스 배열생성[최대게임수]
	private static LottoNumbers lottoMachine = LottoNumbers.getInstance();			// [싱글톤패턴] 객체 생성
	
	public static void main(String[] args) {
		int gameCount = 0;
		int autoCheck = 1;
		
		
		gameCount = inputNumber("몇 게임 ? (1~5) ",1,MAX_GAME);
		for (int i = 0; i < gameCount; i++) {
			boolean autoLotto = true;
			List<Integer> lottoList = new ArrayList<Integer>();
			autoCheck = inputNumber("["+ (i+1) +" 게임] (1.자동 / 2.수동) : ",1, 2);
			if(autoCheck == 1) {
				lottoList = LottoNumbers.getNumbers(6);
				System.out.print(">> ");
				listPrint(lottoList);
				System.out.println();
				
			}
			else {
				for (int j = 0; j < 6; j++) {
					char snum = (char)('\u2780'+j);
					int num = inputNumber(snum + " : ",1, 45);
					boolean check = false;
					for (Integer item : lottoList) {
						if (item == num) check = true;					
					}
					if(check) {
						System.err.println("이미 입력한 번호입니다. [중복된 숫자 : " + num + "]");
						j--;
					}
					else lottoList.add(num);
				}
				Collections.sort(lottoList);
				System.out.print(">> ");
				listPrint(lottoList);
				System.out.println();
				autoLotto = false;
			}
			Lottos lottos = new Lottos((char)(65 + i),autoLotto,lottoList);
			totalList[i] =lottos;
		}
		System.out.println("======================================================");
		System.out.println();
		// 로또 복권 발행
		issuance(gameCount);
		System.out.println();
		// 당첨 번호 출력
		System.out.print("당첨 번호 :");
		listPrint(lottoMachine.getWinNumbers());
		System.out.println();
		System.out.println("보너스 번호 : " + lottoMachine.getBonusNum());
		System.out.println();
		System.out.println("------------------------------------------------------");
		// 당첨 결과
		listWinning();
	}
	
	// 번호 입력
	static int inputNumber(String str,int a, int b) { // [M1000]-->
		int num = 0;
		boolean check = true;
		do {
			System.out.print(str);
			try {
				num = sc.nextInt();
				sc.nextLine();
				if( num < a || num > b) { 
					System.err.println( a + "~" + b + "사이의 정수만 입력 가능합니다.");
				}
				else check = false;
			} catch (Exception e) {
				System.err.println( a + "~"+ b +"사이의 정수만 입력 가능합니다.");
				sc.nextLine();
			}
		} while (check);
		return num;
	}//<--[M1000]
	
	// 로또 번호 출력
	static void listPrint(List<Integer> list) { // [M2000]-->
		for (Integer lotto : list) {
			System.out.print((lotto<10?" ":"")+lotto+" ");
		}
	}//<--[M2000]
	
	// 복권 발행
	static void issuance(int count) { // [M3000]-->
		DecimalFormat df = new DecimalFormat("#,###");
		
		System.out.println("############ 인생역전 Lottoria ############");
		// 발행기간 출력
		lottoMachine.getDate();
		
		System.out.println("-----------------------------------------");
		for (Lottos lottos : totalList) {
			if(lottos == null) break;
			System.out.print(lottos.getCharSort() + ". ");
			System.out.print(lottos.getTypeCheck()?"자  동":"수  동");
			for (Integer lotto : lottos.getNumList()) {
				System.out.print((lotto<10?" ":"")+lotto+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------");
		System.out.println("금액\t\t\t\t ₩" + df.format(count * 1000));
		System.out.println("#########################################");
	}//<--[M3000]
	
	// 당첨 결과
	static void listWinning() {	// [M4000]-->
		System.out.println("#################### 당첨 결과 ####################");
		for (Lottos lottos : totalList) { // 당첨 결과 시작 [F4100]-->
			if(lottos == null) break;
			int winCount = 0;
			boolean bonusCheck = false;
			System.out.print(lottos.getCharSort() + ". ");
			System.out.print(lottos.getTypeCheck()?"자  동":"수  동");
			for (Integer lotto : lottos.getNumList()) { // [F4110]-->
				for (Integer item : lottoMachine.getWinNumbers()) {
					if(lotto == item) winCount++;
					if(item == lottoMachine.getBonusNum()) bonusCheck = true;
				}
				System.out.print((lotto<10?" ":"")+lotto+"   ");
			}//<--[F4110]
			
			switch (winCount) { // 당첨 여부 출력 [S4120]-->
				case 3 : System.out.print("(5등 당첨)"); break;
				case 4 : System.out.print("(4등 당첨)"); break;
				case 5 : 
					if(bonusCheck) System.out.print("(2등 당첨 축하합니다.)");
					else System.out.print("(3등 당첨)"); 
					break;
				case 6 : System.out.print("(1등 당첨!!!! 축하합니다!!!!)"); break;
				default : System.out.print(" (낙첨)");
			}//<--[S4120]
			System.out.println();
		}//<--[F4100]
		System.out.println("#################################################");
	}//<--[M4000]
	
}//<--[Main]
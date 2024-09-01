package Q13_로또리아당첨확인;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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

/**
 * 로또 번호 생성기
 */
class LottoNumbers{
	private static LottoNumbers instance = new LottoNumbers();
	private static int bonusNum = 0;
	public static List<Integer> getNumbers(int num) {
		List<Integer> lottoList = new ArrayList<Integer>();
		for(int i = 0; i < num ; i++) {
			boolean check = false;
			int rnd = new Random().nextInt(45) + 1;
			for (Integer item : lottoList) {
				if (item == rnd) check = true;					
			}
			if(num == 7 && i == 6) {
				bonusNum = rnd;
				break;
			}	
			if(check) i--;
			else lottoList.add(rnd);
		}
				
		Collections.sort(lottoList);
		return lottoList;
	}
	private LottoNumbers () {
	}
	public static int getBonusNum() {
		return bonusNum;
	}
	public static LottoNumbers getInstance() {
		if( instance == null ) {
			instance = new LottoNumbers();
		}
		return instance;
	}
}

/**
 * 전체 로또번호 정보를 담을 객체
 */
class Lottos {
	char charSort;
	boolean typeCheck;
	List<Integer> numList;
	public Lottos(char charSort, boolean typeCheck, List<Integer> numList) {
		this.charSort = charSort;
		this.typeCheck = typeCheck;
		this.numList = numList;
	}
	public char getCharSort() {
		return charSort;
	}
	public void setCharSort(char charSort) {
		this.charSort = charSort;
	}
	public boolean isTypeCheck() {
		return typeCheck;
	}
	public void setTypeCheck(boolean typeCheck) {
		this.typeCheck = typeCheck;
	}
	public List<Integer> getNumList() {
		return numList;
	}
	public void setNumList(List<Integer> numList) {
		this.numList = numList;
	}
	
	@Override
	public String toString() {
		return "Lottos [charSort=" + charSort + ", typeCheck=" + typeCheck + ", numList=" + numList + "]";
	}
}

public class Main {
//	private final static int PAY_DATE_DAY = 366;								// 지급기한 1년(365) 하고 1일 더 = 366일
	private final static int MAX_GAME = 5;										// 최대 게임수 5
	static Scanner sc = new Scanner(System.in);									// 입력 객체 선언
//	private static Calendar now = Calendar.getInstance();						// 현재 시간 추출
	private static Lottos[] totalList = new Lottos[MAX_GAME];					// Lottos클래스 배열생성[최대게임수]
	private final static List<Integer> WIN_NUMBERS = LottoNumbers.getNumbers(7); // 당첨번호
	
	public static void main(String[] args) {
		int gameCount = 0;
		int autoCheck = 1;
		gameCount = inputNumber("몇 게임 ? ",1,5);
		for (int i = 0; i < gameCount; i++) {
			List<Integer> lottoList = new ArrayList<Integer>();
			autoCheck = inputNumber("["+ (i+1) +" 게임]1. 자동 2. 수동 : ",1, 2);
			if(autoCheck == 1) {
				lottoList = LottoNumbers.getNumbers(6);
				System.out.print(">> ");
				listPrint(lottoList);
			}
			else {
				for (int j = 1; j <= 6; j++) {
					int num = inputNumber(j + "번째 숫자 입력 : ",1, 45);
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
			}
			Lottos lottos = new Lottos((char)(65 + i),true,lottoList);
			totalList[i] =lottos;
		}
		System.out.println("======================================================");
		// 당첨 번호 출력
		System.out.print("당첨 번호 :");
		listPrint(WIN_NUMBERS);
		System.out.println("------------------------------------------------------");
		// 입력된 로또 번호 출력
		for (Lottos lottos : totalList) {
			if(lottos == null) break;
			int winLevel = 0;
			int winCount = 0;
			boolean bonusCheck = false;
			System.out.print(lottos.getCharSort() + ".\t");
			for (Integer lotto : lottos.getNumList()) {
				for (Integer item : WIN_NUMBERS) {
					if(lotto == item) winCount++;
					if(item == LottoNumbers.getBonusNum()) bonusCheck = true;
				}
				System.out.print((lotto<10?" ":"")+lotto+" ");
			}
			System.out.print("\t당첨 개수 : " + winCount);
			
			switch (winCount) {
				case 3 : System.out.print(" - 5등 당첨"); break;
				case 4 : System.out.print(" - 4등 당첨"); break;
				case 5 : 
					if(bonusCheck) System.out.print(" - 2등 당첨 축하합니다.");
					else System.out.print(" - 3등 당첨"); 
					break;
				case 6 : System.out.print(" - 1등 당첨!!!! 축하합니다!!!!"); break;
			}
			System.out.println();
		}
	}
	
	// 번호 입력
	static int inputNumber(String str,int a, int b) {
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
			}
		} while (check);
		
		return num;
	}
	// 로또 번호 출력
	static void listPrint(List<Integer> list) {
		for (Integer lotto : list) {
			System.out.print((lotto<10?" ":"")+lotto+" ");
		}
		System.out.println();
	}
}

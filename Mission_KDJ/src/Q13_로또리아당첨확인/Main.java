package Q13_로또리아당첨확인;

import java.util.ArrayList;
import java.util.Calendar;
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
class LottoNumbers{
	private static LottoNumbers instance = new LottoNumbers();
	public static List<Integer> getNumbers() {
		List<Integer> lottoList = new ArrayList<Integer>();
		for(int i = 0; i < 6 ; i++) {
			int rnd = new Random().nextInt(45) + 1;
			lottoList.add(rnd);
			if(lottoList.get(i) == rnd) i--;
		}
		Collections.sort(lottoList);
		return lottoList;
	}
	private LottoNumbers () {
	}
	public static LottoNumbers getInstance() {
		if( instance == null ) {
			instance = new LottoNumbers();
		}
		return instance;
	}
}

/**
 * 
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
	final static int PAY_DATE_DAY = 366;				// 지급기한 1년(365) 하고 1일 더 = 366일
	final static int MAX_GAME = 5;						// 최대 게임수 5
	static Scanner sc = new Scanner(System.in);			// 입력 객체 선언
	static Calendar now = Calendar.getInstance();		// 현재 시간 추출
	static Lottos[] totalList = new Lottos[MAX_GAME];	// Lottos클래스 배열생성[최대게임수]
	
	public static void main(String[] args) {
		//LottoNumbers lottoNumbers = LottoNumbers.getInstance();
		int gameCount = 0;
		System.out.print("1~5사이 정수 입력 : ");
		try {
			gameCount = sc.nextInt();
			sc.nextLine();
			if( gameCount > MAX_GAME || gameCount < 1) { 
				System.err.println("1~5사이의 정수만 입력 가능합니다.");
				return;
			}
		} catch (Exception e) {
			System.err.println("1~5사이의 정수만 입력 가능합니다.");
			return;
		}
		
		
		for (int i = 0; i < gameCount; i++) {
			List<Integer> lottoList = LottoNumbers.getNumbers();
			for (Integer lotto : lottoList) {
				System.out.print((lotto<10?" ":"")+lotto+" ");
			}
			System.out.println();
			totalList[i].setCharSort((char)(40 + i));
			totalList[i].setTypeCheck(true);
			totalList[i].setNumList(lottoList);
		}
	}
	
}

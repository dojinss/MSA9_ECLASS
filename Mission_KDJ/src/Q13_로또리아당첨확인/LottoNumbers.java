package Q13_로또리아당첨확인;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 로또 번호 생성기
 */
class LottoNumbers{ 
	private static LottoNumbers instance = new LottoNumbers();			// [싱글톤패턴] 단일 인스턴스 생성
	private static int bonusNum = 0;									// 보너스 번호 담을 변수
	private final static List<Integer> WIN_NUMBERS = getNumbers(7); 	// 당첨번호
	private final static int PAY_DATE_DAY = 366;						// 지급기한 1년(365) 하고 1일 더 = 366일
	private static Date now = new Date();							// 현재 시간 추출
	/**
	 * 랜덤 번호 6개생성
	 * List - ArrayList 객체로 반환
	 * @param num
	 * @return
	 */
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
		Collections.sort(lottoList);				// 리스트 오름차순 정렬
		return lottoList;							// 번호 6개 담긴 리스트 반환
	}
	public void getDate() {
		Calendar cal = Calendar.getInstance();
		int nowDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int nowHour = cal.get(Calendar.HOUR_OF_DAY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd일 (E) hh:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd일 (E)");
		long dayTime = (1000*60*60*24);
		long afterDrawDay = (Calendar.SATURDAY - nowDayOfWeek) * dayTime;
		long afterPayDay = PAY_DATE_DAY * dayTime;
		
		if(nowHour < 6 && nowDayOfWeek < 7) 
			System.err.println("판매시간이 아닙니다.");
		else if((nowHour < 6 || nowHour > 19) && nowDayOfWeek == 7 ) 
			System.err.println("판매시간이 아닙니다.");
		else {
			System.out.print("발행일 : ");
			System.out.print(sdf.format(now));
			System.out.println();
			System.out.print("추첨일 : " + sdf2.format(now.getTime() + afterDrawDay ) + " 20:00:00");
			System.out.println();
			System.out.print("지급기한 : " + sdf2.format(now.getTime() + afterPayDay ));
			System.out.println();
		}
	}
	
	// getter
	public List<Integer> getWinNumbers() {
		return WIN_NUMBERS;
	}
	public int getBonusNum() {
		return bonusNum;
	}
	// getInstance [싱글톤패턴]
	// 객체 선언시 new 를 사용하지 않고 getInstance로 객체 선언 및 사용
	public static LottoNumbers getInstance() {
		if( instance == null ) {
			instance = new LottoNumbers();
		}
		return instance;
	}
	
}
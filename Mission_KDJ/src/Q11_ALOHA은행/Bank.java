package Q11_ALOHA은행;

import java.util.Iterator;
import java.util.Scanner;

/**
 * 	
 * ALOHA은행은 예금액을 최대 10억까지 관리할 수 있는 통장을 개설해주고 있다. 
 * 최근 보이스피싱 사기가 많아 한 번에 송금할 수 있는 금액을 1,000,000 원으로 제한하여 
 * 예금주의 계좌를 안전하게 보호하고 있다. 아래의 <조건>과 <실행결과>를 참고하여 
 * [Account.java, Bank.java] 클래스를 작성 하시오.
		
	<조건>
	- ALOHA은행의 금고에는 최대 1조 까지 안전하게 보관할 수 있다. 따라서, ALOHA은행이 수용할 수 있는
	최대 고객 수는 1,000 명이다.
	- Account 객체를 기본 생성 시 계좌번호, 예금주, 잔고는 각각 “계좌없음”, “이름없음“, 0 으로 초기화한다.
	- Account 객체의 멤버변수는 Getter, Setter 메소드를 이용하여 접근한다.
	- 잔고 직접 지정과 입금 및 출금은 허용된 금액 범위에서만 적용 가능하도록 한다.
 */
public class Bank {
	final static int MAX_ACCOUNTS 	= 1000;			// 최대 고객수 1,000명
	final static int MAX_DEPOSIT 	= 1000000;		// 최대 송금 가능 금액 1,000,000원
	final static int MAX_MONEY		= 1000000000;	// 최대 예금액 1억원
	static Account[] accounts = new Account[MAX_ACCOUNTS]; // 고객정보 저장할 배열
	// 계좌등록
	static public void create(String name, String num, int money, String password) {
		Account account = new Account(num,name,money,password);
		int cnt = account.getAccountCount();
		accounts[cnt-1] = account;
		return;
	}
	// 입금
	static public void deposit(  ) {
		
	}
	
	// 출금
	static public void withdraw() {
		
	}
	
	// 계좌 조회
	static public void inquiry() {
		
	}
	
	// 계좌 목록
	static public void list() {
		System.out.println("============= 계좌 목록 =============");
		System.out.println("예금주\t\t계좌번호\t\t잔고");
		for (Account account : accounts) {
			if(account == null) break;
			System.out.print(account.getName()+"\t\t");
			System.out.print(account.getNumber()+"\t\t");
			System.out.print(account.getMoney());
			System.out.println();
		}
	}
	
	// 종료
	static public void end() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		do {			
			System.out.println("===================================");
			System.out.println("1. 계좌등록");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 계좌조회");
			System.out.println("5. 계좌목록");
			System.out.println("6. 종료");
			System.out.println("===================================");
			System.out.print("입력>>");
			int N = sc.nextInt();
			sc.nextLine();
			if( N == 0 ) break;
			
			switch (N) {
				case 1:
					System.out.print("계좌번호>>");
					String num = sc.nextLine();
					System.out.print("예금주>>");
					String name = sc.nextLine();
					System.out.print("최초예금액>>");
					int money = sc.nextInt();
					sc.nextLine();
					System.out.print("비밀번호>>");
					String password = sc.nextLine();
					create(name, num, money, password);					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					list();
					break;
			}
			
		} while (true);
		System.out.println("시스템을 종료합니다.");
		sc.close();
	}
}

package Q11_ALOHA은행;

import java.text.DecimalFormat;
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
	final static int MAX_ACCOUNTS 	= 1000;							// 최대 고객수 1,000명
	private static int accountCount = 0;							// 현재 고객수
	static Account[] accounts = new Account[MAX_ACCOUNTS];			// 고객정보 저장할 배열
	static DecimalFormat decFormat = new DecimalFormat("#,###");	// 천 단위 마다 (,) 
	// 계좌등록
	static public void create(String name, String num, int money, String password) {
		if(inquiry(num) != null) {
			System.err.println("이미 존재하는 계좌 번호 입니다.");
			return;
		}
		Account account = new Account(num,name,money,password);
		
		if(accountCount >= MAX_ACCOUNTS) {
			System.err.println("최대 고객수(1000명)에 도달하여 등록할 수 없습니다.");
			return;
		}
		accounts[accountCount++] = account;
		return;
	}
	
	// 입금
	static public void deposit( Account ac, int money  ) {
		ac.setMoney(ac.getMoney() + money);
		System.out.println("‘"+ ac.getName() +"‘ 님의 계좌에 " + decFormat.format(money) + " 원이 입금되었습니다.");
	}
	
	// 출금
	static public void withdraw( Account ac, int money) {
		ac.setMoney(ac.getMoney() - money);
		System.out.println("‘"+ ac.getName() + "‘ 님의 계좌에 " + decFormat.format(money) + "원이 출금되었습니다.");
	}
	
	// 계좌 조회
	static public Account inquiry(String num) {
		for (Account account : accounts) {
			if(account == null) break;
			if(account.getNumber().equals(num)) {
				Account reac = account;
				return reac;
			}
		}
		return null;
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
	
	// 비밀번호 체크
	static public Boolean pwdCheck( Account ac, String pwd ) {
		if(ac.getPassword().equals(pwd)) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num = "";
		String name = "";
		int money = 0;
		String password = "";
		
		do {			
			System.out.println("===================================");
			System.out.println("1. 계좌등록");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 계좌조회");
			System.out.println("5. 계좌목록");
			System.out.println("0. 종료");
			System.out.println("===================================");
			System.out.print("입력>>");
			int N = sc.nextInt();
			sc.nextLine();
			if( N == 0 ) break;
			else if( N < 0 || N > 5) {
				System.err.println("0 ~ 5 사이 정수만 입력 가능합니다.");
			}
			switch (N) {
				case 1:
					System.out.print("계좌번호>>");
					num = sc.nextLine();
					System.out.print("예금주>>");
					name = sc.nextLine();
					System.out.print("최초예금액>>");
					money = sc.nextInt();
					sc.nextLine();
					System.out.print("비밀번호>>");
					password = sc.nextLine();
					create(name, num, money, password);					
					break;
				case 2:
					System.out.print("계좌번호>>");
					num = sc.nextLine();
					Account account = inquiry(num);
					if(account == null) {
						System.err.println("존재하지 않는 계좌입니다.");
						break;
					}
					System.out.print("입금액>>");
					money = sc.nextInt();
					if (money > Account.getMaxDeposit()) {
						System.err.println("최대 송금 가능 금액은 1,000,000원 입니다.");
						break;
					}
					if (account.getMoney() > Account.getMaxMoney()) {
						System.err.println("최대 예금액은 10억원 입니다.");
						break;
					}
					name = inquiry(num).getName();
					System.out.println("‘"+ name +"’님에게 입금하는게 맞으십니까?");
					System.out.println("1. 예");
					System.out.println("2. 아니오");
					System.out.print("입력>>");
					int check = sc.nextInt();
					if(check == 1)
						deposit(inquiry(num),money);
					else
						break;
					break;
				case 3:
					System.out.print("계좌번호>>");
					num = sc.nextLine();
					if(inquiry(num) == null) {
						System.err.println("존재하지 않는 계좌입니다.");
						break;
					}
					System.out.print("비밀번호>>");
					password = sc.nextLine();
					Account wdAcc = inquiry(num);
					if(pwdCheck(wdAcc,password)) {
						System.out.print("출금액>>");
						money = sc.nextInt();
						sc.nextLine();
						if(money > wdAcc.getMoney()) {
							System.err.println("잔액이 부족합니다.");
							break;
						}
						else withdraw(wdAcc, money);
					}
					else {
						System.err.println("비밀번호가 다륿니다!");
						break;
					}
					
					break;
				case 4:
					System.out.println("============= 계좌조회 =============");
					System.out.print("계좌번호>>");
					num = sc.nextLine();
					if(inquiry(num) == null) {
						System.err.println("존재하지 않는 계좌입니다.");
						break;
					}
					System.out.print("비밀번호>>");
					password = sc.nextLine();
					Account inAcc = inquiry(num);
					if(pwdCheck(inAcc,password)) {
						System.out.println("‘" + inAcc.getName() + "’님의 계좌잔액은 " + decFormat.format(inAcc.getMoney())  + " 원 입니다.");
					}
					else {
						System.err.println("비밀번호가 다릅니다!");
						break;
					}
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

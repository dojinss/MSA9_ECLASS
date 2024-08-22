package Q11_ALOHA은행;
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
public class Account {
	final static int MAX_ACCOUNTS 	= 1000;					// 최대 고객수 1,000명
	
	String number;			// 계좌번호
	String name;			// 예금주명
	int money;				// 잔고
	String password;		// 비밀번호
	
	private static int accountCount = 0;	// 현재 고객수
	
	// 생성자
	// - Account 객체를 기본 생성 시 계좌번호, 예금주, 잔고는 각각 “계좌없음”, “이름없음“, 0 으로 초기화한다.
	public Account() {
		this("계좌없음", "이름없음", 0,"");		
	}
	public Account(String number, String name, int money, String password) {
		if(accountCount == MAX_ACCOUNTS) {
			System.err.println("최대 고객수(1000명)에 도달하여 더이상 등록 하싨 수 없습니다.");
			return;
		}
		this.number = number;
		this.name = name;
		this.money = money;
		this.password = password;
		accountCount++;
	}
	
	// getter, setter
	// - Account 객체의 멤버변수는 Getter, Setter 메소드를 이용하여 접근한다.
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// 현재 고객수 반환
	public int getAccountCount() {
		return accountCount;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", money=" + money + ", password=" + password
				+ ", accountCount=" + accountCount + "]";
	}
	
}

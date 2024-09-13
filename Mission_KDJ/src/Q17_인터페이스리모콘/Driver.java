package Q17_인터페이스리모콘;

public class Driver {
	public static void main(String[] args) {
		/*
		 * 인터페이스를 구현한 클래스 객체를 만드는법
		 * - 인터페이스타입 객체명 = new 구현클래스();
		*/
		
		// RC Car
		RemoteControl carRc = new RcCar();
		carRc.turnOn();
		carRc.parking(false);
		carRc.setSpeed(20);
		carRc.parking(true);
		carRc.turnOff();
		System.out.println();
		
		
		RemoteControl.chageBattery();	// static 메소드이기에 바로호출가능
		System.out.println();
		
		// 드론
		RemoteControl droneRc = new Drone();
		droneRc.turnOn();
		// default 메소드는 오버라이딩 하지 않아도 바로 사용가능
		droneRc.parking(false);
		droneRc.setSpeed(15);
		droneRc.parking(true);
		droneRc.turnOff();
		System.out.println();
		
	}
}

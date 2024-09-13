package Q17_인터페이스리모콘;

public class Drone implements RemoteControl{
	
	int speed;
	
	
	@Override
	public void turnOn() {
		System.out.println("드론 전원 ON");
	}

	@Override
	public void turnOff() {
		System.out.println("드론 전원 OFF");
	}

	@Override
	public void setSpeed(int speed) {
		if (speed > MAX_SPEED)		{System.err.println("최대 속력 초과");this.speed = MAX_SPEED;}
		else if (speed < MIN_SPEED) {System.err.println("최저 속력 미만");this.speed = MIN_SPEED;}
		else 						{this.speed = speed;}
		System.out.println("현재 속도 : " + this.speed);
	}
	
}

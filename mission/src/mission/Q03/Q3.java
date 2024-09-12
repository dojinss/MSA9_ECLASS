package mission.Q03;

public class Q3 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 100; i++) {
			boolean check = true;
			//1의 자리수에 3,6,9가 포함되어 있을때
			if(i%10 == 3) {				//i를 10으로 나눈 나머지가 3일때
				System.out.print("*");	//* 출력
				check = false;			//숫자가 아닐경우 false
			}
			else if(i%10 == 6) {		
				System.out.print("*");
				check = false;
			}
			else if(i%10 == 9) {
				System.out.print("*");
				check = false;
			}
			
			//10의 자리수에 3,6,9가 포함되어 있을때
			if((i%100)/10 == 3) {		//i를 100으로 나눈 나머지를 10으로 나눈 값이 3(10의자리)이면
				System.out.print("*");	//* 출력
				check = false;
			}
			else if((i%100)/10 == 6) {
				System.out.print("*");
				check = false;
			}
			else if((i%100)/10 == 9) {
				System.out.print("*");
				check = false;
			}
			if(check) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}

package Q03_369게임;

public class Main {
	public static void main(String[] args) {
		
		int start = 1;
		int end = 100;
		
		// 첫번째
		System.out.println(":::::::::::::::: 1번 ::::::::::::::::");
		int[] checkNum = {3,6,9};
		boolean check = true;
		for (int i = start; i <= end; i++) {
			check = true;
			for (int j = 0; j < checkNum.length; j++) {
				if( i % 10 == checkNum[j])	{check = false;System.out.print("*");}
				if( i / 10 == checkNum[j])	{check = false;System.out.print("*");}
			}
			if(check) 	System.out.print(i);
			else 		System.out.print("\t["+i+"]");
			System.out.println();
		}
		
		
		
		// 두번째
		System.out.println(":::::::::::::::: 2번 ::::::::::::::::");
		for (int i = start; i <= end; i++) {
			int checkNum1 = i % 10;
			int checkNum10 = i / 10;
			boolean numCheck = true;

			boolean check3	 = false;
			boolean check6	 = false;
			boolean check9	 = false;
			
			boolean check30	 = false;
			boolean check60	 = false;
			boolean check90	 = false;
			
			check3 = checkNum1 % 3 == 0 && checkNum1 != 0;
			check6 = checkNum1 % 6 == 0 && checkNum1 != 0;
			check9 = checkNum1 % 9 == 0 && checkNum1 != 0;
			if(check3 || check6 || check9) {
				System.out.print("*");
				numCheck = false;
			}
			if(i > 10) {
				check30 = checkNum10 % 3 == 0;
				check60 = checkNum10 % 6 == 0;
				check90 = checkNum10 % 9 == 0;
				if(check30 || check60 || check90) {
					System.out.print("*");
					numCheck = false;
				}
			}
			
			if(numCheck)	System.out.print(i);
			else			System.out.print("\t["+i+"]");
			
			System.out.println();
			
		}
		
	}
}

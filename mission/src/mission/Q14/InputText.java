package mission.Q14;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class InputText {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader( System.in );
		FileWriter fw = null;
		
		int data = 0;
		try {
			fw = new FileWriter("student.txt");
			while((data = isr.read()) != -1){
				fw.write(data);		// 파일 출력
			}
			isr.close();
			fw.close();
			System.out.println("텍스트 파일이 저장 되었습니다.");
		} catch (Exception e) {
			System.err.println("입출력 시, 에러가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
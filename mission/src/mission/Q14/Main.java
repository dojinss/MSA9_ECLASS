package mission.Q14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ALOHA 스터디에서 월말 코딩 대회를 열었다. 매니저는 학생들의 성적을 취합하여 “student.txt” 파일로 정리하였다. 
 * 한 학생의 성적은 다음과 같은 양식으로 기록되어 있다. txt 파일에서 학생들의 성적정보 (번호/이름/성적/수업이름) 추출하여, 
 * 성적순으로 내림차순, 번호 순으로 오름차순 정렬하여 출력하시오.
 */


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// 파일 경로
		String filePath = "student.txt";
		System.out.print("번호\t");
		System.out.print("이름\t");
		System.out.print("성적\t");
		System.out.print("반\t");
		System.out.println();
		try (
			// 해당 객체를 사용하여, 문자 단위로 데이터 출력
			FileReader fr = new FileReader(filePath);
			// 해당 객체를 이용하여, 데이터 출력 성능 향상
			BufferedReader br = new BufferedReader(fr);
		) {
			String text;
			// readLine() : 파일의 문자 데이터를 한 줄씩 입력
			//			    데이터가 더이상 없으면 null 반환
			while( (text = br.readLine()) != null ) {
				String[] printText = text.split("/");
				for (String item : printText) {
					System.out.print(item + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package mission.Q15;

import java.util.ArrayList;
import java.util.List;

/**
 * ALOHA 스터디는 모든 수강생에게 다양한 교재를 제공하기 위해 작은 도서관을 운영하려고 한다. 
 * 이 도서관의 교재를 관리하기 위한 프로그램을 아래의 조건에 따라 구현하시오.

	- 구현할 기능
	1. isbn, title, writer, content, price 를 멤버변수로 갖는 Book 클래스 정의
	2. Book 클래스의 생성자를 정의하되, 최소 1번 이상 오버로딩 하시오.
	3. Book 클래스의 멤버변수의 값을 가져오고, 지정하는 getter, setter 메소드 정의
	4. Book 클래스의 멤버변수들을 정리된 문자열 형태로 반환해주는 toString 메소드 정의
	5. Book 객체를 생성할 Library 클래스 정의. 아래의 출력결과와 같이 실행되도록 main 메소드를 작성하시오.
	
	<조건>
	- 객체는 별도로 입력받지 않고, 출력결과와 동일한 정보를 갖도록 생성한다.
	- 생성된 Book 객체들은 컬렉션에 추가하고 반복문을 이용하여 출력한다.
 */
public class Library {
	
	public static void main(String[] args) {
		
		List<Book> bookList = new ArrayList<Book>();
		bookList.add( new Book("123123","이게 자바냐","감자바","자바 감자바",33000) );
		bookList.add( new Book("112112","정보처리기사","김휴먼","국가기술자격",45000) );
		bookList.add( new Book("001001","실무 DB ","박디비","디비디비딥",60000) );
		
		System.out.println("==================== ALOHA 스터디 도서관 ====================");
		
		for (Book book : bookList) {
			System.out.print( book.getIsbn() + "|" );
			System.out.print( book.getTitle() + "\t\t|" );
			System.out.print( book.getWriter() + "\t|" );
			System.out.print( book.getContent() + (book.getContent().length() < 6?"\t":"")+ "\t|" );
			System.out.print( book.getPrice() );
			System.out.println();
		}
	}
}
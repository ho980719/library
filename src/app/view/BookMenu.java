package app.view;

import app.controller.BookController;
import app.vo.Book;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
  private Scanner sc = new Scanner(System.in);
  private BookController bookController = new BookController();

  public void mainMenu() {
    System.out.println("== Welcome KH Library ==");
    /**
     1. 새 도서 추가 // insertBook () 실행
     2. 도서 전체 조회 // selectList ()
     3. 도서 검색 조회 // searchBook ()
     4. 도서 삭제 // deleteBook ()
     5. 도서 명 오름차순 정렬 // ascBook()
     9. 종료 // “프로그램을 종료합니다.” 출력 후 main()으로 리턴
     메뉴 번호 선택 : >> 입력 받음
     // 메뉴 화면 반복 실행 처리
     // 잘 못 입력 하였을 경우 "잘못 입력하였습니다. 다시 입력해주세요" 출력 후 반복
     */
    System.out.println("     1. 새 도서 추가 // insertBook () 실행\n" + "     2. 도서 전체 조회 // selectList ()\n" + "     3. 도서 검색 조회 // searchBook ()\n" + "     4. 도서 삭제 // deleteBook ()\n" + "     5. 도서 명 오름차순 정렬 // ascBook()\n"
        + "     9. 종료 // “프로그램을 종료합니다.” 출력 후 main()으로 리턴");
    switch (sc.next()) {
      case "1": insertBook();
      case "2": selectList();
//      case "3": insertBook();
//      case "4": insertBook();
//      case "5": insertBook();
//      case "9": insertBook();
      default: {
        mainMenu();
      }
    }
  }

  // 1. 새 도서 추가용 view 메소드
  public void insertBook() {
    /**
     1. 도서명 입력받기 (String title)
     2. 저자명 입력받기 (String author)
     3. 장르 입력받기 (int category) --> 숫자로 입력받기 (1.인문 / 2.자연과학 / 3.의료 / 4.기타)
     4. 가격 입력받기 (int price)
     5. 매개변수 생성자를 이용하여 Book 객체 생성
     (객체 생성 시 장르 번호 별로 조건식 이용해 장르번호가 아닌 장르 명으로 값 넘겨야 함)
     6. bc(BookController)의 insertBook으로 위의 Book 객체 전달
     */
    Scanner scanner = new Scanner(System.in);
    System.out.println("title : ");
    String title = scanner.next();
    System.out.println("author : ");
    String author = scanner.next();
    System.out.println("category (1.인문 / 2.자연과학 / 3.의료 / 4.기타) : ");
    int category = scanner.nextInt();
    System.out.println("price : ");
    int price = scanner.nextInt();

    String categoryStr = "";
    switch (category) {
      case 1: categoryStr = "인문";
      case 2: categoryStr = "자연과학";
      case 3: categoryStr = "의료";
      case 4: categoryStr = "기타";
    }

    bookController.insertBook(new Book(title, author, categoryStr, price));
  }

  public void selectList() {
    List<Book> books = bookController.selectList();
    if (books.isEmpty()) {
      System.out.println("비어있음 like 은평이머리");
    } else {
      for (Book book : books) {
        System.out.println(book.toString());
      }
    }
  }
}

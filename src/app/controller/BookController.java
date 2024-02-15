package app.controller;

import app.vo.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookController {
  private final List<Book> list = new ArrayList<>();

  public BookController() {
  }

  // list 추가
  public void insertBook(Book book) {
    list.add(book);
  }

  // list 조회
  public List<Book> selectList() {
    return list;
  }

  // list 검색
  public List<Book> searchBook(String keword) {
    return list.stream().filter(x -> x.getTitle().compareTo(keword) > 0).collect(Collectors.toList());
  }

  // list 삭제
  public Book deleteBook(String title, String author) {
    // List를 순회 하면서 title과 author가 같은 첫번째 객체 반환
    Optional<Book> book = list.stream().filter(x -> x.getTitle().equals(title) && x.getAuthor().equals(author)).findFirst();

    // Optional 찾아보셈 개꿀임 이거
    if (book.isPresent()) {
      // 존재한다면 remove
      list.remove(book);
      return book.get();
    } else {
      // 없다면 return null
      return null;
    }
  }

  // 정렬
  public static void ascBook(List<Book> list) {
    list.sort(Comparator.comparing(Book::getTitle));
  }

  // 제목 내림차순 정렬 함수
  public static void descBook(List<Book> list) {
    list.sort(Comparator.comparing(Book::getTitle).reversed());
  }
}

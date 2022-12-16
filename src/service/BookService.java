package service;

import model.Book;

import java.util.List;

public interface BookService {

    List <Book> createBooks(List<Book>books);

    List<Book> getAllBooks();

    List<Book> getBooksByGenre(String genre) throws MyException;

    Book removeBookById(Long id) throws MyException;

    List<Book> sortBooksByPriceInDescendingOrder();

    List<Book> filterBooksByPublishedYear();// Konsolgo akyrky 10 jilda chygarylgan kitepter chyksyn

    List<Book> getBookByInitialLetter() throws MyException;

    Book maxPriceBook();

}

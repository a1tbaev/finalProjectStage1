import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.BookServiceImple;
import service.MyException;
import service.UserServiceImple;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.

        Book book = new Book(1L,"Harry Potter", Genre.FANTASY, new BigDecimal(100), "Adam", Language.ENGLISH, LocalDate.of(2001, 2,1));
        Book book1 = new Book(12L,"Harry Potter", Genre.FANTASY, new BigDecimal(100), "Adam", Language.ENGLISH, LocalDate.of(2001, 2,1));
        Book book2 = new Book(13L,"Harry Potter", Genre.FANTASY, new BigDecimal(100), "Adam", Language.ENGLISH, LocalDate.of(2001, 2,1));
        Book book3 = new Book(14L,"Harry Potter", Genre.FANTASY, new BigDecimal(100), "Adam", Language.ENGLISH, LocalDate.of(2001, 2,1));
        Book book4 = new Book(15L,"Harry Potter", Genre.FANTASY, new BigDecimal(100), "Adam", Language.ENGLISH, LocalDate.of(2001, 2,1));
        List<Book> bookList = new LinkedList<>();
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        User user = new User(1L, "Adil", "Aitbaev", "adil@gmail.com", "+996123456", Gender.MALE, new BigDecimal(12000), null);
        User user1 = new User(2L, "Bektur", "Aitbaev", "adil@gmail.com", "+996123456", Gender.MALE, new BigDecimal(12000), null);
        User user2 = new User(3L, "Beknazar", "Aitbaev", "adil@gmail.com", "+996123456", Gender.MALE, new BigDecimal(12000), null);
        User user3 = new User(4L, "Nuriza", "Muratova", "adil@gmail.com", "+996123456", Gender.MALE, new BigDecimal(12000), null);
        User user4 = new User(5L, "Kanykei", "Akjoltoi kyzy", "adil@gmail.com", "+996123456", Gender.MALE, new BigDecimal(12000), null);
        List<User> userList = new LinkedList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        BookServiceImple bookServiceImple = new BookServiceImple();
        UserServiceImple userServiceImple = new UserServiceImple();

        while (true){
            switch (scanner.nextInt()){
                case 1 -> bookServiceImple.createBooks(bookList).forEach(System.out::println);
                case 2 -> bookServiceImple.getAllBooks().forEach(System.out::println);
                case 3 -> {
                    System.out.println("write genre:");
                    bookServiceImple.getBooksByGenre(input.next()).forEach(System.out::println);
                }
                case 4 ->{
                    System.out.println("write write id to delete book:");
                    System.out.println(bookServiceImple.removeBookById(input.nextLong()));
                }
                case 5 -> bookServiceImple.sortBooksByPriceInDescendingOrder().forEach(System.out::println);
                case 6 -> bookServiceImple.filterBooksByPublishedYear().forEach(System.out::println);
                case 7 -> bookServiceImple.getBookByInitialLetter().forEach(System.out::println);
                case 8 -> System.out.println(bookServiceImple.maxPriceBook());
                case 9 -> userServiceImple.createUser(userList);
                case 10 -> userServiceImple.findAllUsers();
                case 11 -> System.out.println(userServiceImple.findUserById(input.nextLong()));
                case 12 -> System.out.println(userServiceImple.removeUserByName(input.next()));
                case 13 -> userServiceImple.updateUser(input.nextLong());
                case 14 -> System.out.println(userServiceImple.buyBooks(input.next(), bookList));

            }
        }
    }
}
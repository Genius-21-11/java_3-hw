// Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц. 
// Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания после 2010 г, включительно.

import java.util.ArrayList;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        Books book1 = new Books("Война и мир", "Толстой", 290.23, 1996, 13);
        Books book2 = new Books("Масло", "Росси", 190.99, 1800, 1);
        Books book3 = new Books("Метафизика", "Аристотель", 54.99, -400, 100);
        Books book4 = new Books("Хлеб и зрелища", "Маркс", 45.99, 1850, 200);
        Books book5 = new Books("Айран2", "Казакович", 20.99, 2017, 13);

        List<Books> booksList = new ArrayList<>();

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);
        booksList.add(book5);
        System.out.println(booksList);

        StringBuilder sortedBooks = new StringBuilder();
        for (Books books : booksList) {
            if (isPrime(books.getPgNum()) && books.getAuthor().toLowerCase().contains("а")) {
                if (books.getYear() >= 2010 && books.getYear() <= 2023) {
                    sortedBooks.append(books.getName()).append("\n");
                }
            }
        }
        System.out.println(sortedBooks);
    }

    private static boolean isPrime(Integer num) {

        if (num == 1) {
            return true;
        }
        if ((num % 2 == 0 && num != 2) || (num % 3 == 0 && num != 3) || (num % 5 == 0 && num != 5)) {
            return false;
        }
        for (int i = 2; i < num * num; i++) {
            if (i != num) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;

    }


}
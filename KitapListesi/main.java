import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Book> arr=new ArrayList<>();
        arr.add(new Book("Kitap 1", "Yazar 1", 100, LocalDate.of(2010, 1, 2)));
        arr.add(new Book("Kitap 2", "Yazar 2", 150, LocalDate.of(2011, 2, 2)));
        arr.add(new Book("Kitap 3", "Yazar 3", 200, LocalDate.of(2012, 3, 2)));
        arr.add(new Book("Kitap 4", "Yazar 4", 250, LocalDate.of(2013, 4, 2)));
        arr.add(new Book("Kitap 5", "Yazar 5", 300, LocalDate.of(2014, 5, 2)));
        arr.add(new Book("Kitap 6", "Yazar 6", 350, LocalDate.of(2015, 6, 2)));
        arr.add(new Book("Kitap 7", "Yazar 7", 400, LocalDate.of(2016, 7, 2)));
        arr.add(new Book("Kitap 8", "Yazar 8", 450, LocalDate.of(2017, 8, 2)));
        arr.add(new Book("Kitap 9", "Yazar 9", 500, LocalDate.of(2018, 9, 2)));
        arr.add(new Book("Kitap 10", "Yazar 10", 550, LocalDate.of(2019, 10, 2)));
        

        Map<String,String> bookMap=arr.stream().collect(Collectors.toMap(Book::getName, Book::getWriter));

        System.out.println("Kitaplar: " + bookMap);


       List<Book> filterBook = arr.stream()
                           .filter(book -> book.getHistory() > 200)
                           .collect(Collectors.toList());

        System.out.println("Kitap Sayfa Sayisi 250 Büyük Olanlar : " + filterBook);


        Map<String ,LocalDate> bookMap2=arr.stream().collect(Collectors.toMap(Book::getWriter,Book::getPublicationDate));

        System.out.println("------ " + bookMap2);
    }
}

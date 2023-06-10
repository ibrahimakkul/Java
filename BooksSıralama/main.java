
import java.util.Set;
import java.util.TreeSet;


public class main{
    
    public static void main(String[] args) {
    

         Set<Book> bookSetByName = new TreeSet<>();
        bookSetByName.add(new Book("Kitap 1", 200, "Yazar 1", "2022-01-01"));
        bookSetByName.add(new Book("Kitap 3", 150, "Yazar 3", "2022-03-01"));
        bookSetByName.add(new Book("Kitap 2", 300, "Yazar 2", "2022-02-01"));
        bookSetByName.add(new Book("Kitap 5", 250, "Yazar 5", "2022-05-01"));
        bookSetByName.add(new Book("Kitap 4", 100, "Yazar 4", "2022-04-01"));


        System.out.println("Kitaplar isme göre sirali:");
        for (Book book : bookSetByName) {
            System.out.println(book.getTitle());
        }



         Set<Book> bookSetByPageCount = new TreeSet<>(new ComperatorBook());
        bookSetByPageCount.add(new Book("Kitap 1", 200, "Yazar 1", "2022-01-01"));
        bookSetByPageCount.add(new Book("Kitap 3", 150, "Yazar 3", "2022-03-01"));
        bookSetByPageCount.add(new Book("Kitap 2", 300, "Yazar 2", "2022-02-01"));
        bookSetByPageCount.add(new Book("Kitap 5", 250, "Yazar 5", "2022-05-01"));
        bookSetByPageCount.add(new Book("Kitap 4", 100, "Yazar 4", "2022-04-01"));

        System.out.println("Kitaplar sayfa sayisina göre sirali:");
        for (Book book : bookSetByPageCount) {
            System.out.println(book.getTitle());
        }
    
}
}
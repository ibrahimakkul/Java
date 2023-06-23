import java.time.LocalDate;

public class Book{
    private String name;
    private String writer;
    private int history;
    private LocalDate publicationDate;





    public Book(String name, String writer, int history, LocalDate publicationDate) {
        this.name = name;
        this.writer = writer;
        this.history = history;
        this.publicationDate = publicationDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getHistory() {
        return history;
    }
    public void setHistory(int history) {
        this.history = history;
    }
     public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
    @Override
    public String toString() {
        return "" + history ;
    }
    

}
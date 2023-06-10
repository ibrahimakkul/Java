import java.util.Comparator;

public class ComperatorBook implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        
        return Integer.compare(o1.getPageCount(), o2.getPageCount());
    }
    
}

import java.util.ArrayList;
import java.util.List;

public class main{
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Diyarbakirspor");
        System.out.println("Trabzonspor");

        FixtureGenerator generator = new FixtureGenerator(teams);
        generator.generateFixtures();
        generator.printFixtures();
    
        
    }
}
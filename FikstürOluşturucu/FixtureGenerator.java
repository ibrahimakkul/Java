import java.util.ArrayList;
import java.util.List;

public class FixtureGenerator {
    private List<String> teams;
    private List<String> fixtures;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
        this.fixtures = new ArrayList<>();
    }

    public void generateFixtures() {
        int numTeams = teams.size();
        boolean isEven = numTeams % 2 == 0;

        if (!isEven) {
            teams.add("Bay");
            numTeams++;
        }

        int numRounds = numTeams - 1;
        int numMatchesPerRound = numTeams / 2;

        List<String> homeTeams = new ArrayList<>(teams.subList(0, numTeams / 2));
        List<String> awayTeams = new ArrayList<>(teams.subList(numTeams / 2, numTeams));

        for (int round = 0; round < numRounds; round++) {
            StringBuilder roundFixture = new StringBuilder("Round " + (round + 1) + "\n");

            for (int match = 0; match < numMatchesPerRound; match++) {
                String homeTeam = homeTeams.get(match);
                String awayTeam = awayTeams.get(match);

                roundFixture.append(homeTeam).append(" vs ").append(awayTeam).append(" ");
            }

            fixtures.add(roundFixture.toString().trim());

            String lastHomeTeam = homeTeams.get(homeTeams.size() - 1);
            String firstAwayTeam = awayTeams.get(0);

            homeTeams.remove(homeTeams.size() - 1);
            awayTeams.remove(0);

            homeTeams.add(1, firstAwayTeam);
            awayTeams.add(lastHomeTeam);
        }
    }

    public void printFixtures() {
        for (String fixture : fixtures) {
            System.out.println(fixture);
        }
    }
}
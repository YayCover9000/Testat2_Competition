import java.util.List;

public interface IRegistering {

    public CompetitionVO promoteNewCompetition(String name, int max);

    public void addAthlete(AthleteVO obj)
            throws NullPointerException, NoCompetitionException, IllegalStateException;

    public void deleteAthlete(AthleteVO obj)
            throws NullPointerException, NoCompetitionException, IllegalStateException;

    public void startCompetition() throws NoCompetitionException;

    public List<AthleteVO> sort()
            throws NoAthletesException, NoCompetitionException;
}

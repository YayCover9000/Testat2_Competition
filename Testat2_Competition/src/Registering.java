import java.util.Collections;
import java.util.List;

class Registering implements IRegistering {
    private CompetitionVO currentCompetition;

    public Registering() {}

    public CompetitionVO promoteNewCompetition(String name, int max) {
        currentCompetition = new CompetitionVO(name, StateOfCompetitionVO.AVAILABLE, max);
        return currentCompetition;
    }

    public void addAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException {
        if (obj == null) throw new NullPointerException("obj must not be null.");
        if (currentCompetition == null) throw new NoCompetitionException("There is no competition.");

        StateOfCompetitionVO state = currentCompetition.getState();
        List<AthleteVO> athletes = currentCompetition.getAthletes();

        if (state == StateOfCompetitionVO.STARTED) throw new IllegalStateException("The competition is started.");
        if (state == StateOfCompetitionVO.FULL) throw new IllegalStateException("The competition is full.");

        currentCompetition.addAthlete(obj);
        if (athletes.size() >= currentCompetition.getMax()) {
            currentCompetition.setState(StateOfCompetitionVO.FULL);
        }
    }

    public void deleteAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException {
        if (obj == null) throw new NullPointerException("obj must not be null.");
        if (currentCompetition == null) throw new NoCompetitionException("There is no competition.");

        StateOfCompetitionVO state = currentCompetition.getState();

        if (state == StateOfCompetitionVO.STARTED) throw new IllegalStateException("The competition is started.");

        boolean removed = currentCompetition.deleteAthlete(obj);
        if (removed && state == StateOfCompetitionVO.FULL) {
            currentCompetition.setState(StateOfCompetitionVO.AVAILABLE);
        }
    }

    public void startCompetition() throws NoCompetitionException {
        if (currentCompetition == null) throw new NoCompetitionException("There is no competition.");
        currentCompetition.setState(StateOfCompetitionVO.STARTED);
    }

    public List<AthleteVO> sort() throws NoAthletesException, NoCompetitionException {
        if (currentCompetition == null) throw new NoCompetitionException("There is no competition.");
        List<AthleteVO> list = currentCompetition.getAthletes();
        if (list.isEmpty()) throw new NoAthletesException("There are no athletes.");

        Collections.sort(list);
        return list;
    }
}

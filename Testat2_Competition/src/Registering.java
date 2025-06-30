
import java.util.*;


public class Registering implements IRegistering {

    private CompetitionVO currentCompetition;

    public Registering() {}

    public CompetitionVO promoteNewCompetition(String name, int max){
        this.currentCompetition = new CompetitionVO(name, StateOfCompetitionVO.AVAILABLE, max);
        return currentCompetition;
    }

    public void addAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException {
        if(obj == null) throw new NullPointerException("obj is null.");
        if(currentCompetition == null) throw new NoCompetitionException("There is no competition.");


        switch(currentCompetition.getState()) {
            case AVAILABLE -> {
                if(currentCompetition.getAthletes().size() < currentCompetition.getMax()) {
                    currentCompetition.addAthlete(obj);
                    if(currentCompetition.getAthletes().size() == currentCompetition.getMax()) {
                        currentCompetition.setState(StateOfCompetitionVO.FULL);
                    }

                }else {
                    currentCompetition.setState(StateOfCompetitionVO.FULL);
                    throw new IllegalStateException("Competition is Full.");
                }
            }
            case FULL -> throw new IllegalStateException("Competition is Full.");
            case STARTED -> throw new IllegalStateException("Competition is already Started.");
        }
    }

    public void deleteAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException {
        if(obj == null) throw new NullPointerException("obj is null.");
        if(currentCompetition == null) throw new NoCompetitionException("There is no competition.");

        switch (currentCompetition.getState()) {
            case AVAILABLE, FULL -> {
                boolean removed = currentCompetition.deleteAthlete(obj);
                if(removed && currentCompetition.getState() == StateOfCompetitionVO.FULL) {
                    currentCompetition.setState(StateOfCompetitionVO.AVAILABLE);
                }
            }
            case STARTED -> throw new IllegalStateException("The competition is started.");
        }
    }

    public void startCompetition() throws NoCompetitionException{
        if(currentCompetition == null){
	        throw new NoCompetitionException("There is no competition.");
        } else {
            currentCompetition.setState(StateOfCompetitionVO.STARTED);
        }
    }

    public List<AthleteVO> sort() throws NoAthletesException, NoCompetitionException{
        if(currentCompetition == null){
	        throw new NoCompetitionException("There is no competition.");
        }
        if(currentCompetition.getAthletes() == null) {
            throw new NoAthletesException("There are no athletes.");
        }
        List<AthleteVO> sortedAthletes = new ArrayList<>(currentCompetition.getAthletes());
        Collections.sort(sortedAthletes);
        return sortedAthletes;
    }

    //Setter und Getter
    public CompetitionVO getCurrentCompetition() {
        return currentCompetition;
    }

    public void setCurrentCompetition(CompetitionVO currentCompetition) {
        this.currentCompetition = currentCompetition;
    }

}

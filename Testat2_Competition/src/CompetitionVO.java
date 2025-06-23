import java.util.LinkedList;
import java.util.List;

class CompetitionVO {
    private String name;
    private StateOfCompetitionVO state;
    private int max;
    private List<AthleteVO> athletes;

    public CompetitionVO(String name, StateOfCompetitionVO state, int max) {
        this.name = name;
        this.state = state;
        this.max = max;
        this.athletes = new LinkedList<>();
    }

    public void addAthlete(AthleteVO obj) {
        athletes.add(obj);
    }

    public boolean deleteAthlete(AthleteVO obj) {
        return athletes.remove(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        for (AthleteVO a : athletes) {
            sb.append("\n").append(a);
        }
        return sb.toString();
    }

    public String getName() { return name; }
    public int getMax() { return max; }
    public StateOfCompetitionVO getState() { return state; }
    public void setState(StateOfCompetitionVO state) { this.state = state; }
    public List<AthleteVO> getAthletes() { return athletes; }
    public void setAthletes(List<AthleteVO> athletes) { this.athletes = athletes; }
}
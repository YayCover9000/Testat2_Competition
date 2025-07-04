package Solving;

import java.util.*;

public class CompetitionVO   {
    private String name;
    private int max;
    private StateOfCompetitionVO state;
    private List<AthleteVO> athletes;

    public CompetitionVO(String name, StateOfCompetitionVO state, int max) {
        setName(name);
        setState(state);
//        this.state=state;
        setMax(max);
        this.athletes = new LinkedList<AthleteVO>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());

        //Fans falls Fans
        if(athletes != null) {
            for(AthleteVO fan : athletes) {
                sb.append(fan.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public void addAthlete(AthleteVO obj) {
        if(obj == null) throw new NullPointerException("obj must not be null.");
        athletes.add(obj);
    }

    public boolean deleteAthlete(AthleteVO obj) {
        if(obj == null) throw new NullPointerException("obj must not be null.");

        Iterator<AthleteVO> it = athletes.iterator();
        while(it.hasNext()) {
            if(it.next().equals(obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    //Setter und Getter
    public String getName() { return name; }
    public int getMax() { return max; }
    public void setState(StateOfCompetitionVO state) {
        this.state = state;
    }
    public StateOfCompetitionVO getState() {
        return state;
    }
    public List<AthleteVO> getAthletes() { return athletes; }
    public void setAthletes(List<AthleteVO> athletes) { this.athletes = athletes; }
    public void setName(String name) {
        this.name = name;
    }
    public void setMax(int max) {
        this.max = max;
    }

}
public class AthleteVO implements Comparable<AthleteVO> {
    private String name;

    public AthleteVO(String name) {
        setName(name);
    }

    public AthleteVO() {
        this(null);
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(AthleteVO other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AthleteVO other = (AthleteVO) obj;
        return name != null && name.equals(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
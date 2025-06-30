
public  class AthleteVO implements Comparable<AthleteVO>{

    private String name;


    public AthleteVO( String name) {
        setName(name);
    }

    public AthleteVO() {
        this(null);
    }

    public String toString() {
        return name;
    }

    public int compareTo(AthleteVO obj) {
        if(obj == null) throw new NullPointerException("Vergleich mit null ist nicht erlaubt.");

        if(this.name == null && obj.name == null) return 0;
        if(this.name == null) return -1;
        if(obj.name == null) return -1;

        return this.name.compareTo(obj.name);
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
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    // /
    // / Setter und Getter
    // /

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

} 

Die Klassen NoCompetitionException und NoAthletesException sind checked Exceptions, die wie in der Vorlesung vorgestellt implementiert werden sollen.

StateOfCompetitionVO ist ein Aufzählungsdatentyp mit den Konstanten:  

    AVAILABLE
    FULL
    STARTED

Die Klasse AthleteVO soll das Interface java.lang.Comparable implementieren. Erweitern Sie die Klasse AthleteVO entsprechend.

Die Klasse CompetitionVO dient der Objektverwaltung und hat die Instanzattribute:

    name vom Datentyp String
    max vom Datentyp int
    Das Attribut legt die maximal Anzahl von Objekten in athletes fest.
    state vom Datentyp StateOfCompetitionVO
    athletes vom Datentyp java.util.List
    Hier werden die Objekte von AthleteVO typsicher in einer java.util.LinkedList verwaltet.

Die Klasse CompetitionVO setzt das Geheimnisprinzip um. Sie hat einen Initialisierungskonstruktor mit drei Parametern und initialisiert alle Attribute. Sie hat nur die Java-Standard-Operation toString.

    String toString()
    toString gibt einen String zurück, der name und - falls vorhanden - alle athletes jeweils als String enthält.
    void addAthlete(AthleteVO obj)
    fügt eine Objekt von AthleteVO der Liste hinzu
    boolean deleteAthlete(AthleteVO obj)
    löscht das erste Element in der Liste, das für obj und sich mit equals true ergibt. Es wird true zurückgegeben, falls ein Element gefunden und gelöscht wurde, sonst false.

(Tipp: Setzen Sie für die Implementierung von add und delete geeignete Methoden des Collection-Frameworks ein.)

Die Klasse Registering implementiert das Interface IRegistering.

Die Klasse hat eine Instanzvariable

    currentCompetition vom Datentyp CompetitionVO.

Die Klasse Registering setzt das Geheimnisprinzip um. Sie hat einen Standardkonstruktor. Sie hat KEINE Java-Standard-Operationen.

Sie implementiert die Methoden des Interface IRegistering. Falls nicht anderes angegeben wird und der Parameter einer Methode null ist, sollte die NullPointerException zugelassen werden. Die Fehlermeldung lautet "obj must not be null.".

    public CompetitionVO promoteNewCompetition(String name, int max)
    Es wird ein neues Objekt von CompetitionVO mit name, state ist AVAILABLE und max erzeugt und zurückgeben.
    (Es findet keine Fehlerbehandlung für die Parameter statt.)
    public void addAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException
    Die Methode fügt das Objekt obj athletes von currentCompetition hinzu, wenn state von currentCompetition AVAILABLE ist und solange max von currentCompetition nicht erreicht ist. Wird max erreicht, wird zusätzlich state von currentCompetition auf FUll gesetzt.
    Ist state von currentCompetition FUll oder STARTED erfolgt mit der passenden Exception die Fehlermeldung "The competition is full." oder "The competition is started."

Ist currentCompetition null erfolgt mit der passenden Exception die Fehlermeldung "There is no competition."

    public void deleteAthlete(AthleteVO obj)) throws NullPointerException, NoCompetitionException, IllegalStateException
    Die Methode löscht das Objekt obj aus athletes von currentCompetition, wenn state AVAILABLE ist. Die Methode löscht das Objekt obj aus athletes von currentCompetition auch, wenn state FULL ist. Falls dabei das Löschen erfolgreich war, wird state von currentCompetition auf AVAILABLE gesetzt.
    Ist state von currentCompetition STARTED erfolgt mit der passenden Exception die Fehlermeldung "The competition is started."
    Ist currentCompetition null erfolgt mit der passenden Exception die Fehlermeldung "There is no competition."

    public void startCompetition() throws NoCompetitionException
    Ist currentCompetition null erfolgt mit der passenden Exception die Fehlermeldung "There is no competition." Sonst wird state von currentCompetition auf STARTED gesetzt.

    public List<AthleteVO> sort() throws NoAthletesException, NoCompetitionException
    Ist currentCompetition null erfolgt mit der passenden Exception die Fehlermeldung "There is no competition." Hat currentCompetition keine athletes erfolgt mit der passenden Exception die Fehlermeldung " "There are no athletes.". Sonst wird athletes von currentCompetition nach der natürlichen Ordnung sortiert und zurückgeben.

public  class AthleteVO {
	
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

import java.util.List;


public interface IRegistering {
	
	public CompetitionVO promoteNewCompetition(String name, int max);
	
	public void addAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException ;
	
	public void deleteAthlete(AthleteVO obj) throws NullPointerException, NoCompetitionException, IllegalStateException ;
	
	public void startCompetition() throws NoCompetitionException;
	
	public List<AthleteVO> sort() throws NoAthletesException, NoCompetitionException;
	

}

![7d92be4b-052c-4fa8-a46f-deb6af7af21f](https://github.com/user-attachments/assets/1fa07e19-e8e0-4a5f-bb51-2ed96aa04270)

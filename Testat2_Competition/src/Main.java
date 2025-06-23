import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Registrierung starten
            Registering reg = new Registering();

            // Neuen Wettbewerb anlegen
            CompetitionVO comp = reg.promoteNewCompetition("100m Sprint", 3);
            System.out.println("Wettbewerb erstellt: " + comp.getName());

            // Athleten anlegen
            AthleteVO a1 = new AthleteVO("Usain Bolt");
            AthleteVO a2 = new AthleteVO("Tyson Gay");
            AthleteVO a3 = new AthleteVO("Yohan Blake");

            // Athleten hinzufügen
            reg.addAthlete(a1);
            reg.addAthlete(a2);
            reg.addAthlete(a3);

            // Ausgabe: Liste aller Athleten
            System.out.println("\nAlle Athleten im Wettbewerb:");
            for (AthleteVO a : comp.getAthletes()) {
                System.out.println("- " + a.getName());
            }

            // Ein Athlet wird entfernt
            reg.deleteAthlete(a2);

            // Nach Löschung: Status wieder AVAILABLE
            System.out.println("\nNach dem Entfernen von Tyson Gay:");
            for (AthleteVO a : comp.getAthletes()) {
                System.out.println("- " + a.getName());
            }

            // Wettbewerb starten
            reg.startCompetition();
            System.out.println("\nWettbewerb gestartet.");

            // Versuch, nach Start noch einen Athleten hinzuzufügen (soll Exception werfen)
            try {
                reg.addAthlete(new AthleteVO("Neuer Athlet"));
            } catch (IllegalStateException ex) {
                System.out.println("\nFehler beim Hinzufügen: " + ex.getMessage());
            }

            // Athleten sortieren (alphabetisch)
            List<AthleteVO> sorted = reg.sort();
            System.out.println("\nSortierte Athletenliste:");
            for (AthleteVO a : sorted) {
                System.out.println("- " + a.getName());
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}

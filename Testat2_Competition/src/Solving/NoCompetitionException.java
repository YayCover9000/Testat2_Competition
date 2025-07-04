package Solving;

public class NoCompetitionException extends Exception {
    public NoCompetitionException(String message) {
        super(message);
    }
    public NoCompetitionException() {super("No Competition.");}
}
public class NoAthletesException extends Exception {
    public NoAthletesException(String message) {
        super(message);
    }
    public NoAthletesException() {super("No Athletes.");}
}
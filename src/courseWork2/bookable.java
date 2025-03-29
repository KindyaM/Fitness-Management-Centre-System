package courseWork2;

public interface Bookable {
    void book(int sessionID, String participantName); // method that books a session
    void cancel(int sessionID, String participantName); // method to cancel the session
}
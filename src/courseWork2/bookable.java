package courseWork2;

public interface bookable {
	void book(int sessionID, String ParticipantName); // method that books a session
	void cancel(int sessionID, String ParticipantName); // method to cancel the session
	
	// an interface is used because these methods will be called in their own way by related classes
	
}

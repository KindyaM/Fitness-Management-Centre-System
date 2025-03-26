package courseWork2;

public abstract class Session implements bookable {
	private static int idCounter = 1;
	private int sessionID;
	private String sessionName;
	private String requiredFitnessLevel;
	private String day;
	private String startTime;
	private int duration;
	private int spacesLeft;
	//The above are the properties of the class Session


	public Session( String sessionName, String requiredFitnessLevel,String day, String startTime, int duration, int spacesLeft) {
		this.sessionID = idCounter++;
		this.sessionName = sessionName;
		this.requiredFitnessLevel = requiredFitnessLevel;
		this.day = day;
		this.startTime = startTime;
		this.duration = duration;
		this.spacesLeft = spacesLeft;
		// these are the parameterized constructors, sessionID calls on the method generateSessionID() that ensures a unique ID
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {

		this.day = day;
	}
	
	public String getSessionName(){
		return sessionName;
		
	}
	
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
		
	}
	
	public String getRequiredFitnessLevel() {
		return requiredFitnessLevel;
		
	}
	
	public void setRequiredFitnessLevel(String requiredFitnessLevel ) {
		this.requiredFitnessLevel = requiredFitnessLevel;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime (String startTime) {
		this.startTime = startTime;
	}
	
	public int getDuration() {
		return duration;
		
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getSpacesLeft() {
	    return spacesLeft;
		
	}
	
	public void setSpacesLeft(int spacesLeft) {
		this.spacesLeft = spacesLeft;
	}
	
	 public int getSessionID() {
		 return sessionID;
	 }
	
	
	 @Override
	 public String toString() {
	     return "Session ID: " + sessionID + " | " + sessionName + 
	            " - Available Spaces: " + spacesLeft + 
	            ", Fitness Level: " + requiredFitnessLevel + 
	            ", Day: " + day + 
	            ", Start Time: " + startTime + 
	            ", Duration: " + duration + " mins";
	 }
	
	public abstract void updateSpaces() ; // Abstract method to be implemented in the subclasses
	

	
}	


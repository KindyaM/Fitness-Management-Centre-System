package courseWork2;

class PilatesSession extends Session{
	private String equipmentNeeded;
	private String coreFocusLevel;
	// these are the exclusive properties of Pilates 
	
	public PilatesSession (String sessionName, String requiredFitnessLevel, String day, String startTime, int duration, int spacesLeft, String equipmentNeeded, String coreFocusLevel) {
		super(sessionName, requiredFitnessLevel, day, startTime, duration, spacesLeft);
		this.equipmentNeeded =  equipmentNeeded;
		this.coreFocusLevel = coreFocusLevel;
		//this constructor includes parameters from both Session and Pilates
	}
	
	@Override
	public void book(int sessionID, String ParticipantName){
		if (getSpacesLeft() > 0) {
			setSpacesLeft(getSpacesLeft ()-1);
			System.out.println("Congratulations on a successful booking " + ParticipantName + " booked for " + getSessionID());
			updateSpaces();
		}else {
			System.out.println("Sorry, there are no more spaces left in" + getSessionID());
		}
	}
	
	
	@Override
	public void cancel(int sessionID, String ParticipantName) {
		setSpacesLeft(getSpacesLeft ()+1);
		System.out.println("Successfully cancelled" + getSessionID());
		
		// Method from 'bookable' that increases the number of spaces left if yoga is cancelled
	}
	@Override
	public void updateSpaces() {
		System.out.println("Updated space for" + getSessionID() + ":" + getSpacesLeft() );
		
		// Shows the number of spaces after book() and cancel()
	}
	
	
	@Override
	public String toString() {
	    return super.toString() + ", Equipment Needed: " + equipmentNeeded;
	}

	// This displays the information from this session
	
	public void setEquipmentNeeded(String equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
            
    }
	 public String getEquipmentNeeded() {
		 return equipmentNeeded;
	 }
	public String coreFocussLevel() {
		return coreFocusLevel;
		
	}
	
	public void setCoreFocusLevel(String coreFocusLevel) {
		this.coreFocusLevel = coreFocusLevel;
	}
}
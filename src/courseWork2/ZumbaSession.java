package courseWork2;

class ZumbaSession extends Session {
	private String danceStyle;
	private int energyLevel;
	
	public ZumbaSession( String sessionName, String requiredFitnessLevel, String day, String startTime,int duration, int spacesLeft, String danceStyle, int energyLevel){
		super(sessionName, requiredFitnessLevel, day, startTime, duration, spacesLeft);
		this.danceStyle = danceStyle;
		this.energyLevel = energyLevel;
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
		//This is a method from the interface 'bookable' that reduces the number of available spaces when Zumba is booked
	@Override
	public void cancel(int sessionID, String ParticipantName) {
		setSpacesLeft(getSpacesLeft ()+1);
		System.out.println("Successfully cancelled" + getSessionID());
		
		// Method from 'bookable' that increases the number of spaces left if Zumba is cancelled
	}
	@Override
	public void updateSpaces() {
		System.out.println("Updated space for" + getSessionID() + ":" + getSpacesLeft());
		
		// Shows the number of spaces after book() and cancel()
	}
	
	@Override
	public String toString() {
	    return super.toString() + ", Dance Style: " + danceStyle;
	}

	
	 public void setDanceStyle(String danceStyle) {
	        this.danceStyle = danceStyle;
	    }
	 
	 public String getDanceStyle() {
		 return danceStyle;
	 }
	 
	 public void setEnergyLevel(int energyLevel) {
	        this.energyLevel = energyLevel;
	       
	    }
	    
	    public int getEnergyLevel() {
	    	return energyLevel;
	    }
	}




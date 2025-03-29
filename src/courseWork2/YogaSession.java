package courseWork2;

class YogaSession extends Session {
    private String yogaStyle;
    private int meditationTime;
    
    public YogaSession(String sessionName, String requiredFitnessLevel, String day, String startTime, int duration, int spacesLeft, String yogaStyle, int meditationTime) {
        super(sessionName, requiredFitnessLevel, day, startTime, duration, spacesLeft);
        this.yogaStyle = yogaStyle;
        this.meditationTime = meditationTime;
    }
	 // for the showDetails() i tried to use void instead of string but i got an error
	// I used two variables baseDetails for the details from the superclass and yogaDetails for the yogaSession 
	// i then returned the sum of the two to get the details from both
    
    public String getYogaStyle() {
        return yogaStyle;
    }
    
    public void setYogaStyle(String yogaStyle) {
        this.yogaStyle = yogaStyle;
    }
    
    public int getMeditationTime() {
        return meditationTime;
    }
    
    public void setMeditationTime(int meditationTime) {
        this.meditationTime = meditationTime;
    }
    
    @Override
    public void updateSpaces() {
        System.out.println("Yoga session spaces updated successfully");
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Yoga Style: " + yogaStyle;
    }
    
    @Override
    public void book(int sessionID, String participantName) {
        if (getSpacesLeft() > 0) {
            setSpacesLeft(getSpacesLeft() - 1);
            System.out.println("✅ Congratulations on a successful booking! " + participantName + " booked for session " + getSessionID());
            updateSpaces();
        } else {
            System.out.println("⚠️ Sorry, there are no more spaces left in session " + getSessionID());
        }
    }
    
    @Override
    public void cancel(int sessionID, String participantName) {
        setSpacesLeft(getSpacesLeft() + 1);
        System.out.println("✅ Successfully cancelled session " + getSessionID() + " for " + participantName);
    }
}
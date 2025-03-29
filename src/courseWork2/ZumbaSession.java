package courseWork2;

class ZumbaSession extends Session {
    private String danceStyle;
    private int energyLevel;
    
    public ZumbaSession(String sessionName, String requiredFitnessLevel, String day, String startTime, int duration, int spacesLeft, String danceStyle, int energyLevel) {
        super(sessionName, requiredFitnessLevel, day, startTime, duration, spacesLeft);
        this.danceStyle = danceStyle;
        this.energyLevel = energyLevel;
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
    
    @Override
    public void updateSpaces() {
        System.out.println("Updated space for session " + getSessionID() + ": " + getSpacesLeft());
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Dance Style: " + danceStyle;
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
package courseWork2;

class PilatesSession extends Session {
    private String equipmentNeeded;
    private String coreFocusLevel;
    
    public PilatesSession(String sessionName, String requiredFitnessLevel, String day, String startTime, int duration, int spacesLeft, String equipmentNeeded, String coreFocusLevel) {
        super(sessionName, requiredFitnessLevel, day, startTime, duration, spacesLeft);
        this.equipmentNeeded = equipmentNeeded;
        this.coreFocusLevel = coreFocusLevel;
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
        return super.toString() + " | Equipment: " + equipmentNeeded;
    }
    
    public void setEquipmentNeeded(String equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }
    
    public String getEquipmentNeeded() {
        return equipmentNeeded;
    }
    
    public String getCoreFocusLevel() {
        return coreFocusLevel;
    }
    
    public void setCoreFocusLevel(String coreFocusLevel) {
        this.coreFocusLevel = coreFocusLevel;
    }
}
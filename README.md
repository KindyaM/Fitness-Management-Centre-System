Define a simple interface Bookable:
 2. Methods:
 • book(SessionID, participantName)- Book a session slot for a participant.
 • cancel(SessionID, participantName)- Cancel a participant’s booking.
 3. Create an abstract class Session that implements Bookable:
 • Properties:
 1
– SessionID (auto-generated)– SessionName– RequiredFitnessLevel– Day– StartTime (as String)– Duration– SpacesLeft
 • Methods:– showDetails()- Display session information.– updateSpaces()- Adjust available spaces when booked.
 4. Create a concrete class YogaSession that extends Session:
 • Exclusive Properties:– YogaStyle (e.g., ”Hatha”, ”Vinyasa”)- Type of Yoga practiced.– MeditationTime (in minutes)- Duration of meditation segment.
 • Implement book and cancel to manage participant bookings and adjust spaces.
 5. Create a concrete class PilatesSession that extends Session:
 • Exclusive Properties:– EquipmentNeeded (e.g., ”Mat”, ”Reformer”)- Required equipment.– CoreFocusLevel (e.g., ”Beginner”, ”Advanced”)- Intensity of core work.
 • Implement book and cancel to manage participant bookings and adjust spaces.
 6. Create a concrete class ZumbaSession that extends Session:
 • Exclusive Properties:– DanceStyle (e.g., ”Salsa”, ”Hip-Hop”)- Dance genre featured.– EnergyLevel (estimated calories burned)- Session intensity measure.
 • Implement book and cancel to manage participant bookings and adjust spaces.
 7. Add Basic Exception Handling:
 • Handle errors like:– Empty session name or invalid input.– Nospaces left in a session.
 8. Create a main class FitAll:
 • Store sessions in an array.
 • Options to:– Showall sessions.– Bookasession slot with a participant name.– Cancel a booking with a participant name.
 2
Example Input and Output:
 Example 1: Displaying Available Sessions
 Input:
 1. Display session timetable
 O

 
 Example 2: Registering for a Session
 Input:
 2. Register for a session
 Enter Participant Name: John Doe
 Enter Session ID: 2

 Registration successful! John Doe has been added to Pilates (Session ID: 1).
 Remaining spaces: 0
 Example 3: Handling a Full Session
 Input:
 2. Register for a session
 Enter Participant Name: Jane Smith
 Enter Session ID: 2
 Output:
 Error: Session is full! Cannot register Jane Smith for Pilates (Session ID: 2).
 | Style: Hatha, Meditation: 10 min
 | Equipment: Mat, Focus: Beginner
 | Dance: Salsa, Energy: 300 cal

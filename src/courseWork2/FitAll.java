package courseWork2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FitAll {
    private static Scanner scanner = new Scanner(System.in);
    // Add a data structure to store bookings
    private static Map<Integer, List<String>> sessionBookings = new HashMap<>();

    public static void main(String[] args) {
        List<Session> sessions = new ArrayList<>();
        sessions.add(new YogaSession("Morning Yoga", "Beginner", "Monday", "10:00 AM", 60, 2, "Hatha", 15));
        sessions.add(new PilatesSession("Evening Pilates", "Intermediate", "Wednesday", "6:00 PM", 45, 4, "Mat", "Intermediate"));
        sessions.add(new ZumbaSession("Party Zumba", "Advanced", "Friday", "8:00 PM", 50, 1, "Salsa", 400));

        // Initialize booking lists for each session
        for (Session session : sessions) {
            sessionBookings.put(session.getSessionID(), new ArrayList<>());
        }

        while (true) {
            System.out.println("\n📌 Available Sessions:");
            displaySessions(sessions);

            System.out.println("\nChoose an option:");
            System.out.println("1. Register for a session");
            System.out.println("2. Cancel a session");
            System.out.println("3. View bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = getValidIntegerInput();

            if (choice == 1) {
                bookSession(sessions);
                pauseBeforeMenu();
            } else if (choice == 2) {
                cancelSession(sessions);
                pauseBeforeMenu();
            } else if (choice == 3) {
                viewBookings(sessions);
                pauseBeforeMenu();
            } else if (choice == 4) {
                System.out.println("Exiting. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Display all available sessions
    private static void displaySessions(List<Session> sessions) {
        System.out.println("Session ID | Session Name     | Fitness Level | Day       | Start Time | Duration | Spaces Left | Additional Info");
        System.out.println("------------------------------------------------------------------------------------------------------");
        for (Session s : sessions) {
            System.out.println(s);
        }
    }

    // Booking a session
    private static void bookSession(List<Session> sessions) {
        System.out.print("Enter your name: ");
        String participantName = scanner.nextLine();

        System.out.print("Enter Session ID: ");
        int sessionID = getValidIntegerInput();

        boolean sessionFound = false;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                if (s.getSpacesLeft() > 0) {
                    s.book(sessionID, participantName);
                    // Store the booking in our data structure
                    sessionBookings.get(sessionID).add(participantName);
                    System.out.println("✅ Booking saved in the system");
                }
                sessionFound = true;
                break;
            }
        }
        if (!sessionFound) {
            System.out.println("⚠️ No session found with ID: " + sessionID);
        }
    }

    // Canceling a session
    private static void cancelSession(List<Session> sessions) {
        System.out.print("Enter your name: ");
        String participantName = scanner.nextLine();

        System.out.print("Enter Session ID to cancel: ");
        int sessionID = getValidIntegerInput();

        boolean sessionFound = false;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                List<String> bookings = sessionBookings.get(sessionID);
                if (bookings.contains(participantName)) {
                    s.cancel(sessionID, participantName);
                    // Remove the booking from our data structure
                    bookings.remove(participantName);
                    System.out.println("✅ Booking removed from the system");
                } else {
                    System.out.println("⚠️ No booking found for " + participantName + " in session ID: " + sessionID);
                }
                sessionFound = true;
                break;
            }
        }
        
        if (!sessionFound) {
            System.out.println("⚠️ No session found with ID: " + sessionID);
        }
    }

    // View all bookings
    private static void viewBookings(List<Session> sessions) {
        System.out.println("\n📋 Current Bookings:");
        System.out.println("Session ID | Session Name | Participants");
        System.out.println("----------------------------------------");
        
        boolean hasBookings = false;
        for (Session s : sessions) {
            int sessionID = s.getSessionID();
            List<String> participants = sessionBookings.get(sessionID);
            
            if (!participants.isEmpty()) {
                hasBookings = true;
                System.out.println(sessionID + " | " + s.getSessionName() + " | " + String.join(", ", participants));
            }
        }
        
        if (!hasBookings) {
            System.out.println("No bookings found in the system.");
        }
    }

    // Get valid integer input
    private static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("⚠️ Invalid input! Enter a number: ");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline to prevent input skipping
        return number;
    }

    // Pause before showing menu again
    private static void pauseBeforeMenu() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();  // Wait for user to press Enter before showing the menu again
    }
}
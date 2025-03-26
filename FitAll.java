package courseWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitAll {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Session> sessions = new ArrayList<>();
        sessions.add(new YogaSession("Morning Yoga", "Beginner", "Monday", "10:00 AM", 60, 2, "Hatha", 15));
        sessions.add(new PilatesSession("Evening Pilates", "Intermediate", "Wednesday", "6:00 PM", 45, 4, "Mat", "Intermediate"));
        sessions.add(new ZumbaSession("Party Zumba", "Advanced", "Friday", "8:00 PM", 50, 1, "Salsa", 400));

        while (true) {
            System.out.println("\n📌 Available Sessions:");
            displaySessions(sessions);

            System.out.println("\nChoose an option:");
            System.out.println("1. Register for a session");
            System.out.println("2. Cancel a session");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = getValidIntegerInput();

            if (choice == 1) {
                bookSession(sessions);
                pauseBeforeMenu();
            } else if (choice == 2) {
                cancelSession(sessions);
                pauseBeforeMenu();
            } else if (choice == 3) {
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
        String participantName = scanner.next();

        System.out.print("Enter Session ID: ");
        int sessionID = getValidIntegerInput();

        boolean sessionFound = false;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                s.book(sessionID, participantName);  // Success message is handled in the subclass
                return;
            }
        }
        if (!sessionFound) {
            System.out.println("⚠️ No session found with ID: " + sessionID);
        }
    }

    // Canceling a session
    private static void cancelSession(List<Session> sessions) {
        System.out.print("Enter your name: ");
        String participantName = scanner.next();

        System.out.print("Enter Session ID to cancel: ");
        int sessionID = getValidIntegerInput();

        boolean sessionFound = false;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                s.cancel(sessionID, participantName);  // Success message is handled in the subclass
                return;
            }
        }
        
        if (!sessionFound) {
            System.out.println("⚠️ No session found with ID: " + sessionID);
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

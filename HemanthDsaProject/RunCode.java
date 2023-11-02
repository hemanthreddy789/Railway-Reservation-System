package HemanthDsaProject;

import java.util.Scanner;

// This class represents the main program to run the Railway Reservation System.
public class RunCode {
    public static void main(String[] args) {
        // Create an instance of the Railway Reservation System.
        trainAndPassenger railwaySystem = new trainAndPassenger();
        
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Railway Reservation System Menu:");
            System.out.println("1. Book a Train Ticket");
            System.out.println("2. Check Train Schedules");
            System.out.println("3. Passenger Details");
            System.out.println("4. Cancel Train Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Collect passenger information and book a train ticket.
                    scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Station Name: ");
                    String stationName = scanner.nextLine();
                    System.out.print("Enter Train Name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Enter Train Number: ");
                    int trainNumber = scanner.nextInt();
                    System.out.print("Enter Date (1-31): ");
                    int date = scanner.nextInt();
                    System.out.print("Enter Month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter Year (e.g., 2023): ");
                    int year = scanner.nextInt();
                    railwaySystem.bookTrainTicket(firstName, lastName, stationName, trainName, trainNumber, date, month, year);
                    break;

                case 2:
                    // Display the train schedules.
                    railwaySystem.checkTrainSchedules();
                    break;

                case 3:
                    // Get passenger details for a specific train.
                    scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Enter Train Name: ");
                    trainName = scanner.nextLine();
                    railwaySystem.passengerDetails(firstName, lastName, trainName);
                    break;

                case 4:
                    // Cancel a train ticket for a passenger.
                    scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Enter Train Name: ");
                    trainName = scanner.nextLine();
                    System.out.print("Enter Train Number: ");
                    trainNumber = scanner.nextInt();
                    railwaySystem.cancelTrainTickets(firstName, lastName, trainName, trainNumber);
                    break;

                case 5:
                    // Exit the program.
                    System.out.println("Thank you for using the Railway Reservation System. Goodbye!");
                    break;

                default:
                    // Handle invalid choices.
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        // Close the scanner to release system resources.
        scanner.close();
    }
}

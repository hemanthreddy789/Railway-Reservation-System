package HemanthDsaProject;

import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;

// This class represents the implementation of the RailwayReservationSystem interface.
public class trainAndPassenger implements RailwayReservationSystem {
    // Queues to store station information and booked tickets.
    Queue<StationInfo> stations = new LinkedList<>();
    Queue<BookingInfo> booking = new LinkedList();
    
    int AvailableSeats;
    int newTicketNumber;
    public int seatNumber;

    public trainAndPassenger() {
        seatNumber = 1;
        AvailableSeats = 1000;
    }

    // Inner class to represent booking information.
    class BookingInfo {
        String firstName;
        String lastName;
        String stationName;
        public String trainName;
        public int trainNumber;
        public int date;
        public int month;
        public int year;
        public int ticketNumber;
        public int seatNumber;

        public BookingInfo(String firstName, String lastName, String stationName, String trainName, int trainNumber, int date, int month, int year, int ticketNumber, int seatNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.stationName = stationName;
            this.trainName = trainName;
            this.trainNumber = trainNumber;
            this.date = date;
            this.month = month;
            this.year = year;
            this.ticketNumber = ticketNumber;
            this.seatNumber = seatNumber;
        }
    }

    @Override
    public void bookTrainTicket(String firstName, String lastName, String stationName, String trainName, int trainNumber, int date, int month, int year) {
        // Check if the provided date is valid.
        if (date > 31 || month > 12 || year != 2023 || date <= 0 || month <= 0) {
            System.out.println("Please provide a valid date.");
        } else if (seatNumber > AvailableSeats) {
            System.out.println("The seats are not available for this train, Mr/Mrs " + firstName + " " + lastName + ".");
        } else {
            // Add the train schedule.
            addTrainSchedule();
            boolean found = false;
            for (StationInfo station : stations) {
                if (trainName.equals(station.trainName) && stationName.equals(station.stationName) && trainNumber == station.trainNumber && date == station.date && month == station.month && year == station.year) {
                    found = true;
                    break;
                }
            }

            if (found) {
                // Generate a unique ticket number.
                do {
                    newTicketNumber = new Random().nextInt(100000);
                } while (isTicketNumberUsed(newTicketNumber));

                // Create and store booking information.
                booking.add(new BookingInfo(firstName, lastName, stationName, trainName, trainNumber, date, month, year, newTicketNumber, seatNumber));
                System.out.println("---------------------------------------------------------------------");
                System.out.println("                               Ticket                ");
                System.out.println("                               ------                ");
                System.out.println("Your Ticket has been confirmed..");
                System.out.println("Name : " + firstName + " " + lastName);
                System.out.println("Train Name : " + trainName);
                System.out.println("Station Name : " + stationName);
                System.out.println("Train Number : " + trainNumber);
                System.out.println("Ticket number : " + newTicketNumber);
                System.out.println("Seat number : " + seatNumber);
                System.out.println("date : " + date + "/" + month + "/" + year);
                System.out.println("                            ..Happy Journey..           ");
                System.out.println("---------------------------------------------------------------------");
                System.out.println();
                seatNumber++;
            } else {
                System.out.println("The Train you are looking for is not available on that date.");
            }
        }
    }

    // Check if a ticket number is used.
    boolean isTicketNumberUsed(int ticketNumber) {
        for (BookingInfo bookingInfo : booking) {
            if (ticketNumber == bookingInfo.ticketNumber) {
                return true;
            }
        }
        return false;
    }

    // Inner class to represent station information.
    class StationInfo {
        public String stationName;
        public String trainName;
        public int trainNumber;
        public int date;
        public int month;
        public int year;

        public StationInfo(String stationName, String trainName, int trainNumber, int date, int month, int year) {
            this.stationName = stationName;
            this.trainName = trainName;
            this.trainNumber = trainNumber;
            this.date = date;
            this.month = month;
            this.year = year;
        }
    }

    // Method to add train schedules to the system.
    public void addTrainSchedule() {
        stations.add(new StationInfo("Punjab", "Train A", 10000, 11, 11, 2023));
        stations.add(new StationInfo("Delhi", "Train B", 10001, 12, 11, 2023));
        stations.add(new StationInfo("Chandigarh", "Train C", 10002, 13, 11, 2023));
        stations.add(new StationInfo("Jalandhar", "Train D", 10003, 14, 11, 2023));
        stations.add(new StationInfo("Phagwara", "Train E", 10004, 15, 11, 2023));
        stations.add(new StationInfo("Ludhiana", "Train F", 10005, 16, 11, 2023));
        stations.add(new StationInfo("Anantapur", "Train G", 10006, 17, 11, 2023));
        stations.add(new StationInfo("Bihar", "Train H", 10007, 18, 11, 2023));
    }

    @Override
    public void checkTrainSchedules() {
        addTrainSchedule();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                          Train Schedule                             ");
        for (StationInfo station : stations) {
            System.out.println("Station Name: " + station.stationName);
            System.out.println("Train Name: " + station.trainName);
            System.out.println("Train Number: " + station.trainNumber);
            System.out.println("Date: " + station.date + "/" + station.month + "/" + station.year);
            System.out.println("---------------------------------------------------------------------");
        }
    }

    @Override
    public void passengerDetails(String firstName, String lastName, String trainName) {
        boolean found = false;

        for (BookingInfo bookingInfo : booking) {
            if (firstName.equals(bookingInfo.firstName) && lastName.equals(bookingInfo.lastName) && trainName.equals(bookingInfo.trainName)) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("                     Passenger Details                ");
                System.out.println("                     -----------------                ");
                System.out.println("Name: " + bookingInfo.firstName + " " + bookingInfo.lastName);
                System.out.println("Train Name: " + bookingInfo.trainName);
                System.out.println("Station Name: " + bookingInfo.stationName);
                System.out.println("Train Number: " + bookingInfo.trainNumber);
                System.out.println("Ticket number: " + bookingInfo.ticketNumber);
                System.out.println("Seat number: " + bookingInfo.seatNumber);
                System.out.println("Date: " + bookingInfo.date + "/" + bookingInfo.month + "/" + bookingInfo.year);
                System.out.println("---------------------------------------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Passenger with the name " + firstName + " " + lastName + " on " + trainName + " not found.");
        }
    }

    @Override
    public void cancelTrainTickets(String firstName, String lastName, String trainName, int trainNumber) {
        boolean found = false;

        for (BookingInfo bookingInfo : booking) {
            if (firstName.equals(bookingInfo.firstName) && lastName.equals(bookingInfo.lastName)
                    && trainName.equals(bookingInfo.trainName) && trainNumber == bookingInfo.trainNumber) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("                     Ticket Cancellation                ");
                System.out.println("                     ---------------------                ");
                System.out.println("Name: " + bookingInfo.firstName + " " + bookingInfo.lastName);
                System.out.println("Train Name: " + bookingInfo.trainName);
                System.out.println("Station Name: " + bookingInfo.stationName);
                System.out.println("Train Number: " + bookingInfo.trainNumber);
                System.out.println("Ticket number: " + bookingInfo.ticketNumber);
                System.out.println("Seat number: " + bookingInfo.seatNumber);
                System.out.println("Date: " + bookingInfo.date + "/" + bookingInfo.month + "/" + bookingInfo.year);
                System.out.println("This ticket has been canceled.");
                System.out.println("---------------------------------------------------------------------");
                booking.remove(bookingInfo);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Passenger with the name " + firstName + " " + lastName + " not found or no matching booking found for cancellation.");
        }
    }
}

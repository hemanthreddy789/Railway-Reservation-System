package HemanthDsaProject;

// This interface represents a Railway Reservation System.
public interface RailwayReservationSystem {
    
    // Book a train ticket for a passenger.
    void bookTrainTicket(String firstName, String lastName, String stationName, String trainName, int trainNumber, int date, int month, int year);

    // Check the schedules of available trains.
    void checkTrainSchedules();
    
    // Get passenger details for a specific train.
    void passengerDetails(String firstName, String lastName, String trainName);

    // Cancel a train ticket for a passenger.
    void cancelTrainTickets(String firstName, String lastName, String trainName, int trainNumber);
}

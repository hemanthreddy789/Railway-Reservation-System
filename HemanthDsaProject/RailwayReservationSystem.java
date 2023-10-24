package HemanthDsaProject;

public interface RailwayReservationSystem {
    void bookTrainTicket(String firstName,String lastName,String stationName,String trainName,int trainNumber, int date, int month, int year);
    void checkTrainSchedules();
    public void passengerDetails(String firstName,String lastName,String trainName);

    void cancelTrainTickets(String firstName,String lastName,String trainName,int trainNumber);

}

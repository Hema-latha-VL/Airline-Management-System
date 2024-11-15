import java.util.ArrayList;
import java.util.Scanner;

class Flight {
    int flightId;
    String destination;
    String status;

    Flight(int flightId, String destination) {
        this.flightId = flightId;
        this.destination = destination;
        this.status = "Scheduled";
    }

    void updateStatus(String status) {
        this.status = status;
    }
}

class AirlineManagementSystem {
    ArrayList<Flight> flights = new ArrayList<>();

    void addFlight(int flightId, String destination) {
        Flight flight = new Flight(flightId, destination);
        flights.add(flight);
        System.out.println("Flight added: ID " + flightId + ", Destination: " + destination);
    }

    void updateFlightStatus(int flightId, String status) {
        for (Flight flight : flights) {
            if (flight.flightId == flightId) {
                flight.updateStatus(status);
                System.out.println("Updated status for Flight ID " + flightId + " to " + status);
                return;
            }
        }
        System.out.println("Flight ID not found.");
    }

    void displayFlights() {
        System.out.println("Current Flights:");
        for (Flight flight : flights) {
            System.out.println("Flight ID: " + flight.flightId + ", Destination: " + flight.destination + ", Status: " + flight.status);
        }
    }

    void bookFlight(int flightId) {
        for (Flight flight : flights) {
            if (flight.flightId == flightId) {
                System.out.println("Flight booked: ID " + flightId + ", Destination: " + flight.destination);
                return;
            }
        }
        System.out.println("Flight ID not found.");
    }
     
    public static void main(String[] args) {
        AirlineManagementSystem system = new AirlineManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAirline Management System");
            System.out.println("1. Add Flight");
            System.out.println("2. Update Flight Status");
            System.out.println("3. Display All Flights");
            System.out.println("4. Book Flight");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight ID: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    system.addFlight(flightId, destination);
                    break;

                case 2:
                    System.out.print("Enter Flight ID: ");
                    flightId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Status: ");
                    String status = scanner.nextLine();
                    system.updateFlightStatus(flightId, status);
                    break;

                case 3:
                    system.displayFlights();
                    break;

                case 4:
                    System.out.print("Enter Flight ID: ");
                    flightId = scanner.nextInt();
                    system.bookFlight(flightId);
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}


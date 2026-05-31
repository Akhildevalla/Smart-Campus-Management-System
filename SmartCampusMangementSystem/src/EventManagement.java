import java.sql.*;
import java.util.Scanner;

public class EventManagement {

    public static void menu(Scanner sc) {

        while (true) {

            System.out.println("\n--- Event Management ---");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Back");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEvent(sc);
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void addEvent(Scanner sc) {

        try {

            Connection con = DBconnection.getConnection();

            System.out.print("Enter Event Name: ");
            String eventName = sc.nextLine();

            System.out.print("Enter Event Date (YYYY-MM-DD): ");
            String eventDate = sc.nextLine();

            System.out.print("Enter Venue: ");
            String venue = sc.nextLine();

            String sql =
                "INSERT INTO events(event_name, event_date, venue) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, eventName);
            ps.setString(2, eventDate);
            ps.setString(3, venue);

            ps.executeUpdate();

            System.out.println("Event Added Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewEvents() {

        try {

            Connection con = DBconnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM events");

            System.out.println("\nID\tEvent Name\tDate\t\tVenue");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("event_name") + "\t" +
                    rs.getDate("event_date") + "\t" +
                    rs.getString("venue"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
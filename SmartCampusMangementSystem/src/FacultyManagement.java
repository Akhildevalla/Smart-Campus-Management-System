import java.sql.*;
import java.util.Scanner;

public class FacultyManagement {

    public static void menu(Scanner sc) {

        while (true) {

            System.out.println("\n--- Faculty Management ---");
            System.out.println("1. Add Faculty");
            System.out.println("2. View Faculty");
            System.out.println("3. Back");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addFaculty(sc);
                    break;

                case 2:
                    viewFaculty();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void addFaculty(Scanner sc) {

        try {
            Connection con = DBconnection.getConnection();

            System.out.print("Enter Faculty ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Faculty Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            String sql = "INSERT INTO faculty VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setString(4, email);

            ps.executeUpdate();

            System.out.println("Faculty Added Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewFaculty() {

        try {
            Connection con = DBconnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM faculty");

            System.out.println("\nID\tName\tDepartment\tEmail");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("department") + "\t" +
                        rs.getString("email"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
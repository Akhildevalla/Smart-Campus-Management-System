import java.sql.*;
import java.util.Scanner;

public class ComplaintManagement {

    public static void menu(Scanner sc) {

        while (true) {

            System.out.println("\n--- Complaint Management ---");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Back");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addComplaint(sc);
                    break;
                case 2:
                    viewComplaints();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void addComplaint(Scanner sc) {

        try {
            Connection con = DBconnection.getConnection();

            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Complaint: ");
            String complaint = sc.nextLine();

            System.out.print("Enter Status: ");
            String status = sc.nextLine();

            String sql = "INSERT INTO complaints(student_id, complaint_text, status) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setString(2, complaint);
            ps.setString(3, status);

            ps.executeUpdate();

            System.out.println("Complaint Added Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewComplaints() {

        try {
            Connection con = DBconnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM complaints");

            System.out.println("\nID\tStudentID\tComplaint\tStatus");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getInt("student_id") + "\t\t" +
                    rs.getString("complaint_text") + "\t" +
                    rs.getString("status"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
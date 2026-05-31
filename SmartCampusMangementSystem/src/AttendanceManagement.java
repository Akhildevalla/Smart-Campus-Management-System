import java.sql.*;
import java.util.Scanner;

public class AttendanceManagement {

    public static void menu(Scanner sc) {

        while (true) {

            System.out.println("\n--- Attendance Management ---");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Back");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    markAttendance(sc);
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void markAttendance(Scanner sc) {

        try {

            Connection con = DBconnection.getConnection();

            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            System.out.print("Enter Status (Present/Absent): ");
            String status = sc.nextLine();

            String sql =
                "INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);

            ps.executeUpdate();

            System.out.println("Attendance Marked Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewAttendance() {

        try {

            Connection con = DBconnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM attendance");

            System.out.println("\nID\tStudentID\tDate\t\tStatus");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getInt("student_id") + "\t\t" +
                    rs.getDate("date") + "\t" +
                    rs.getString("status"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
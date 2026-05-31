import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    public static void menu(Scanner sc) {

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Back");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent(sc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void addStudent(Scanner sc) {

        try {
            Connection con = DBconnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Year: ");
            int year = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setInt(4, year);
            ps.setString(5, email);

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewStudents() {

        try {
            Connection con = DBconnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\nID\tName\tCourse\tYear\tEmail");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("course") + "\t" +
                        rs.getInt("year") + "\t" +
                        rs.getString("email"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteStudent(Scanner sc) {

        try {
            Connection con = DBconnection.getConnection();

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully!");
            else
                System.out.println("Student Not Found!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SMART CAMPUS MANAGEMENT SYSTEM =====");
            System.out.println("1. Student Management");
            System.out.println("2.Faculty Management");
            System.out.println("3.Attendance Management");
            System.out.println("4.Complaint Management");
            System.err.println("5.Event Management");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    StudentManagement.menu(sc);
                    break;
                case 2:
                    FacultyManagement.menu(sc);
                    break;
                case 3:
                    AttendanceManagement.menu(sc);
                    break;
                case 4:
                    ComplaintManagement.menu(sc);
                    break;
                case 5:
                    EventManagement.menu(sc);
                    break;

                case 6:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
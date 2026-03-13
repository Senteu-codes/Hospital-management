import java.util.Scanner;
public class DynamicInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter patient name:");
            String name = scanner.nextLine();
           
        if (name.isEmpty()) {
             System.out.println("Patient name: " + name);
        }
        } catch (Exception e) {
            System.out.println("Enter a valid name!!");
        
        } finally {
            scanner.close();
        }

        try {
            System.out.println("Enter Doctor name:");
            String doctorName = scanner.nextLine();
            System.out.println("Doctor name: " + doctorName);
            if(doctorName.trim().isEmpty()) {
                System.out.println("Doctor name cannot be empty!");
            }
        } catch (Exception e) {
            System.out.println("Enter a valid name");
        } finally {
            scanner.close();
        }
        

        try {
            System.out.println("Enter appointment date:");
            String appointmentDate = scanner.nextLine();
            System.out.println("Appointment date: " + appointmentDate);
        } catch (Exception e) {
            System.out.println("Enter a valid name.");
        } finally {
            scanner.close();
        }

        try {
            System.out.println("Enter bill amount:");
            double billAmount = scanner.nextDouble();
            if (billAmount<0)

            System.out.println("Bill amount: " + billAmount);
        } catch (Exception e) {
            System.out.println("Enter a valid name");
        } finally {
            scanner.close();
        }
    }
}
import java.util.Scanner;

public class DynamicInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== Hospital Management (Dynamic Input) ===\n");

            patient patient = readPatient(scanner);
            System.out.println();

            doctor doctor = readDoctor(scanner);
            System.out.println();

            appointment appointment = readAppointment(scanner);
            System.out.println();

            bill bill = readBill(scanner, patient);
            System.out.println();

            System.out.println("--- Summary ---");
            doctor.displayInfo();
            System.out.println();
            patient.displayInfo();
            System.out.println();
            appointment.displayInfo();
            System.out.println();
            bill.generateBill();
            System.out.println();
            bill.makePayment();

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static patient readPatient(Scanner scanner) {
        System.out.println("Enter patient details:");
        int personId = readInt(scanner, "  Person ID: ");
        String name = readNonEmptyString(scanner, "  Name: ");
        int phone = readInt(scanner, "  Phone (digits only): ");
        String email = readNonEmptyString(scanner, "  Email: ");
        String address = readNonEmptyString(scanner, "  Address: ");
        int patientId = readInt(scanner, "  Patient ID: ");
        String medicalHistory = readNonEmptyString(scanner, "  Medical history: ");
        String insuranceProvider = readNonEmptyString(scanner, "  Insurance provider: ");

        return new patient(personId, name, phone, email, address, patientId, medicalHistory, insuranceProvider);
    }

    private static doctor readDoctor(Scanner scanner) {
        System.out.println("Enter doctor details:");
        int personId = readInt(scanner, "  Person ID: ");
        String name = readNonEmptyString(scanner, "  Name: ");
        int phone = readInt(scanner, "  Phone (digits only): ");
        String email = readNonEmptyString(scanner, "  Email: ");
        String address = readNonEmptyString(scanner, "  Address: ");
        int doctorId = readInt(scanner, "  Doctor ID: ");
        String specialization = readNonEmptyString(scanner, "  Specialization: ");
        String licenseNumber = readNonEmptyString(scanner, "  License number: ");

        return new doctor(personId, name, phone, email, address, doctorId, specialization, licenseNumber);
    }

    private static appointment readAppointment(Scanner scanner) {
        System.out.println("Enter appointment details:");
        int appointmentId = readInt(scanner, "  Appointment ID: ");
        String date = readNonEmptyString(scanner, "  Date (e.g. 2024-07-01): ");
        String time = readNonEmptyString(scanner, "  Time (e.g. 10:00 AM): ");
        String description = readNonEmptyString(scanner, "  Description: ");

        return new appointment(appointmentId, date, time, description);
    }

    private static bill readBill(Scanner scanner, patient patient) {
        System.out.println("Enter billing details:");
        double amount = readDouble(scanner, "  Amount: $");
        return new bill(patient, amount);
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("  Input cannot be empty. Please try again.");
                    continue;
                }
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("  Input cannot be empty. Please try again.");
                    continue;
                }
                double value = Double.parseDouble(line);
                if (value < 0) {
                    System.out.println("  Amount cannot be negative. Please try again.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a valid number (e.g., 123.45).");
            }
        }
    }

    private static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("  Input cannot be empty. Please try again.");
        }
    }
}

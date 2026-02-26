public class  main {
    public static void main(String[] args) {
        doctor doc1 = new doctor(1, "Dr. Smith", 1234567890, "drsmith@hospital.com", "123 Main St", 101, "Cardiology", "LIC12345");
        doc1.displayInfo();

        patient pat1 = new patient(2, "John Doe", 987654321, "johndoe@hospital.com", "456 Oak Ave", 201, "Diabetes", "Insurex");
        pat1.displayInfo();

        appointment app1 = new appointment(301, "2024-07-01", "10:00 AM", "Regular check-up");
        app1.displayInfo();


    }

}
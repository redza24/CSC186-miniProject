import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class HospitalApp {
    private static Scanner scan = new Scanner(System.in); // for string
    private static Scanner scan1 = new Scanner(System.in);
    private static final int MAX_DOCTORS = 2;
    private static final int MAX_PATIENTS = 2;
    private static final int MAX_WARDROOMS = MAX_PATIENTS + MAX_DOCTORS;
    private static Person[] persons = new Person[MAX_PATIENTS + MAX_DOCTORS];
    private static WardRoom[] wardRooms = new WardRoom[MAX_WARDROOMS];
    private static LocalDate currentDate = LocalDate.now();

    public static void main(String[] args) {
        clearScreen();
        int choice = 0;
        while (choice != 8) {
            displayMenu();
            choice = scan1.nextInt();

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    addWardRoom();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    viewPatients();
                    break;
                case 6:
                    viewWardRooms();
                    break;
                case 7:
                    saveRecords();
                    break;
                case 8:
                    System.out.println("Thank you for using our services.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    } // end main

    public static void displayMenu() {
        System.out.println("\n===== Hospital Management System =====");
        System.out.println("Date: " + currentDate);
        System.out.println();
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Assign Patient to Ward Room");
        System.out.println("4. View Doctors");
        System.out.println("5. View Patients");
        System.out.println("6. View Ward Rooms");
        System.out.println("7. Save Records");
        System.out.println("8. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    public static void addDoctor() {
        clearScreen();
        for (int i = 0; i < MAX_DOCTORS; i++) {
            System.out.println("\n<<<<<< ADD DOCTOR >>>>>>>");
            System.out.print("Name: ");
            String name = scan.nextLine().toUpperCase();
            System.out.print("Age: ");
            int age = scan1.nextInt();
            System.out.print("Gender [M/F]: ");
            char gender = scan.nextLine().toUpperCase().charAt(0);
            System.out.print("Specialization [general/specialist/surgeon]: ");
            String specialization = scan.nextLine().toUpperCase();
            System.out.print("Availability [Y/N]: ");
            char availability = scan.nextLine().toUpperCase().charAt(0);
            System.out.print("Contact Number [XXX-XXXXXXX]: ");
            String contactNum = scan.nextLine().toUpperCase();
            System.out.print("Email: ");
            String email = scan.nextLine().toUpperCase();

            // store onto object
            persons[i] = new Doctor(name, age, gender, specialization, availability, contactNum, email);
        }
        System.out.println();
        System.out.println("\u001B[32mData stored successfully.\u001B[0m");
    }

    public static void addPatient() {
        clearScreen();
        for (int i = MAX_DOCTORS; i < MAX_DOCTORS + MAX_PATIENTS; i++) {
            System.out.println("\n<<<<<< ADD PATIENT >>>>>>>");
            System.out.print("Name: ");
            String name = scan.nextLine().toUpperCase();
            System.out.print("Age: ");
            int age = scan1.nextInt();
            System.out.print("Gender [M/F]: ");
            char gender = scan.nextLine().toUpperCase().charAt(0);
            System.out.print("Diagnosis: "); // to receive what kind of sickness patients are having
            String diagnosis = scan.nextLine().toUpperCase();
            System.out.print("Admission Date [dd/mm]: ");
            String admissionDate = scan.nextLine().toUpperCase();
            System.out.print("Discharge Date [dd/mm]: ");
            String dischargeDate = scan.nextLine().toUpperCase();
            System.out.print("Insurance [true/false]: ");
            boolean insurance = scan1.nextBoolean();
            // store onto object
            persons[i] = new Patient(name, age, gender, diagnosis, admissionDate, dischargeDate, insurance);
        }
        System.out.println();
        System.out.println("\u001B[32mData stored successfully.\u001B[0m");
    }

    // choice no.3: Add Ward Room
    public static void addWardRoom() {
        clearScreen();
        for (int i = 0; i < MAX_WARDROOMS; i++) {
            Random random = new Random(50); // random number for ward room
            System.out.println("<<<<<<<<<< ASSIGN PATIENT TO WARD ROOM >>>>>>>>>>");
            System.out.print("Patient Name: ");
            String nameCompare = scan.nextLine().toUpperCase();
            int roomNum = 0;
            if (persons[i] instanceof Patient) {
                Patient pt = (Patient) persons[i];
                if (nameCompare.equalsIgnoreCase(pt.getName())) { // comparing name given to the name in object
                    System.out.print("Day being held in ward: ");
                    int heldWard = scan1.nextInt();
                    System.out.print("Room Type [elite/basic]: ");
                    String roomType = scan.nextLine().toUpperCase();
                    System.out.print("Enter deposit [min RM50]: ");
                    double deposit = scan1.nextDouble();
                    if (roomType.equalsIgnoreCase("elite")) {
                        roomNum = random.nextInt(50);
                        System.out.print("Room Number: " + roomNum);
                        System.out.println();
                        String name = pt.getName();
                        int age = pt.getAge();
                        char gender = pt.getGender();
                        String diagnosis = pt.getDiagnosis();
                        String admissionDate = pt.getAdmissionDate();
                        String dischargeDate = pt.getDischargeDate();
                        boolean insurance = pt.getInsurance();
                        // store onto object
                        wardRooms[i] = new WardRoom(roomType, roomNum, heldWard, deposit, name, age, gender,
                                diagnosis, admissionDate, dischargeDate, insurance);
                        System.out.println("Total Price: RM" + wardRooms[i].calcTotal() + "\n");
                    }
                    if (roomType.equalsIgnoreCase("basic")) {
                        roomNum = random.nextInt(50);
                        System.out.print("Room Number: " + roomNum);
                        System.out.println();
                        String name = pt.getName();
                        int age = pt.getAge();
                        char gender = pt.getGender();
                        String diagnosis = pt.getDiagnosis();
                        String admissionDate = pt.getAdmissionDate();
                        String dischargeDate = pt.getDischargeDate();
                        boolean insurance = pt.getInsurance();
                        // store onto object
                        wardRooms[i] = new WardRoom(roomType, roomNum, heldWard, deposit, name, age, gender,
                                diagnosis, admissionDate, dischargeDate, insurance);
                        System.out.println("Total Price: RM" + wardRooms[i].calcTotal() + "\n");
                    }
                } else {
                    System.out.println("Invalid");
                    System.out.println();
                    addWardRoom(); // to ask the user to input the data correctly
                }
                System.out.println();
                System.out.println("\u001B[32mData stored successfully.\u001B[0m");
            }
        }
    }

    public static void viewDoctors() {
        clearScreen();
        System.out.println("\n===== DISPLAY DOCTORS =====");

        boolean doctorsFound = false;
        for (int i = 0; i < MAX_DOCTORS; i++) {
            if (persons[i] instanceof Doctor) {
                Doctor doctor = (Doctor) persons[i];
                System.out.println(doctor.toString());
                doctorsFound = true;
            }
        }
        if (!doctorsFound) {
            System.out.println("No doctors found.");
        }
    }

    public static void viewPatients() {
        clearScreen();
        System.out.println("\n===== DISPLAY PATIENTS =====");

        boolean patientsFound = false;
        for (int i = MAX_DOCTORS; i < MAX_DOCTORS + MAX_PATIENTS; i++) {
            if (persons[i] instanceof Patient) {
                Patient patient = (Patient) persons[i];
                System.out.println(patient.toString());
                patientsFound = true;
            }
        }
        if (!patientsFound) {
            System.out.println("No patients found.");
        }
    }

    public static void viewWardRooms() {
        clearScreen();
        System.out.println("\n===== DISPLAY WARD ROOMS =====");

        boolean wardRoomsFound = false;
        for (int i = 0; i < MAX_WARDROOMS; i++) {
            if (wardRooms[i] != null) {
                System.out.println(wardRooms[i].toString());
                wardRoomsFound = true;
            }
        }
        if (!wardRoomsFound) {
            System.out.println("No ward rooms found.");
        }
    }

    public static void saveRecords() {
        clearScreen();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hospital_data.txt"))) {
            writer.write("======= HOSPITAL RECORD =======\n");
            writer.write("Date: " + currentDate + "\n");

            writer.write("\n===== DOCTORS =====\n");
            int doctorCount = 0;
            for (int i = 0; i < MAX_DOCTORS + MAX_PATIENTS; i++) {
                if (persons[i] instanceof Doctor) {
                    doctorCount++;
                    writer.write("\n\tDoctor " + doctorCount);
                    Doctor doctor = (Doctor) persons[i];
                    writer.write(doctor.toString() + "\n");
                }
            }
            if (doctorCount == 0) {
                writer.write("No doctors found.\n");
            }

            writer.write("\n===== PATIENTS =====\n");
            int patientCount = 0;
            for (int i = 0; i < MAX_DOCTORS + MAX_PATIENTS; i++) {
                if (persons[i] instanceof Patient) {
                    patientCount++;
                    writer.write("\n\tPatient " + patientCount);
                    Patient patient = (Patient) persons[i];
                    writer.write(patient.toString() + "\n");
                }
            }
            if (patientCount == 0) {
                writer.write("No patients found.\n");
            }

            writer.write("\n===== WARD ROOMS =====\n");
            int wardRoomCount = 0;
            for (int i = 0; i < MAX_WARDROOMS; i++) {
                if (wardRooms[i] != null) {
                    wardRoomCount++;
                    writer.write("\n\tWard Room " + wardRoomCount);
                    writer.write(wardRooms.toString() + "\n");
                }
            }
            if (wardRoomCount == 0) {
                writer.write("No ward rooms found.\n");
            }



            System.out.println("\u001B[32mData saved successfully to hospital_data.txt.\u001B[0m");
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while saving the data to hospital_data.txt.\u001B[0m");
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // ANSI escape code to clear the screen
        System.out.flush();
    }
} // end class

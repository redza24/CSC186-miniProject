import java.io.*;
import java.util.*;
import java.time.*; ///

public class HospitalApp {
    private static Scanner scan = new Scanner(System.in); // for string
    private static Scanner scan1 = new Scanner(System.in);
    private static ArrayList<Person> persons = new ArrayList<>();
    private static ArrayList<WardRoom> wardRooms = new ArrayList<>();
    private static LocalDate currentDate = LocalDate.now();

    public static void main(String[] args) {
        clearScreen();
        int choice = 0;
        while (choice != 8) {
            displayMenu();
            choice = scan1.nextInt();

            switch (choice) {
                case 1:
                    clearScreen();
                    addDoctor();
                    break;
                case 2:
                    clearScreen();
                    addPatient();
                    break;
                case 3:
                    clearScreen();
                    addWardRoom();
                    break;
                case 4:
                    clearScreen();
                    viewDoctors();
                    break;
                case 5:
                    clearScreen();
                    viewPatients();
                    break;
                case 6:
                    clearScreen();
                    viewWardRooms();
                    break;
                case 7:
                    clearScreen();
                    saveRecords();
                    break;
                case 8:
                    clearScreen();
                    System.out.println("\n\tThank you for using our services.\n");
                    break;
                default:
                    clearScreen();
                    System.out.println("\n\t\u001B[31mInvalid choice. Please try again.\u001B[0m\n");
                    break;
            }
        }
    } // end main

    public static void displayMenu() {
        System.out.println("\n===== Hospital Management System =====");
        System.out.println("Date: " + currentDate + "\tDay: " + currentDate.getDayOfWeek());
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
        String email = scan.nextLine();

        // store onto object
        persons.add(new Doctor(name, age, gender, specialization, availability, contactNum, email));
        
        System.out.println();
        System.out.println("\u001B[32mData stored successfully.\u001B[0m");
    }

    public static void addPatient() {
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
        persons.add(new Patient(name, age, gender, diagnosis, admissionDate, dischargeDate, insurance));
        
        System.out.println();
        System.out.println("\u001B[32mData stored successfully.\u001B[0m");
    }

    // choice no.3: Add Ward Room
    public static void addWardRoom() {
        Random random = new Random(50); // random number for ward room
        int roomNum = 0;

        System.out.println("<<<<<<<<<< ASSIGN PATIENT TO WARD ROOM >>>>>>>>>>");
        System.out.print("Patient Name: ");
        String nameCompare = scan.nextLine().toUpperCase();
        boolean nameFound = false;

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i) instanceof Patient) {
                Patient pt = (Patient) persons.get(i);

                if (nameCompare.equalsIgnoreCase(pt.getName())) { // comparing name given to the name in object
                    nameFound = true;
                    System.out.print("Day being held in ward: ");
                    int heldWard = scan1.nextInt();
                    System.out.print("Room Type [elite/basic]: ");
                    String roomType = scan.nextLine().toUpperCase();
                    System.out.print("Enter deposit [min RM50]: ");
                    double deposit = scan1.nextDouble();

                    double coverage = 0;
                    if (pt.getInsurance() == true) {
                        System.out.print("Coverage of that patient's insurance [in percentage]: ");
                        coverage = scan1.nextDouble();
                    }

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
                    
                    WardRoom wardRoom = new WardRoom(roomType, roomNum, heldWard, deposit, name, age, gender,
                            diagnosis, admissionDate, dischargeDate, insurance);
                            double total = wardRoom.calcTotal(coverage);

                    // store onto object
                    wardRooms.add(wardRoom);
                    wardRoom.setPrice(total);

                    System.out.println("\u001B[32mData stored successfully.\u001B[0m");
                }

                System.out.println();
            }
        }
        if (!nameFound) {
            System.out.println("\u001B[31mPatient not found.\u001B[0m");
        }
    }

    public static void viewDoctors() {
        System.out.println("\n===== DISPLAY DOCTORS =====");

        int doctorCount = 0;
        for (Person person : persons) {
            if (person instanceof Doctor) {
                doctorCount++;
                System.out.print("\n\tDoctor " + doctorCount);
                Doctor doctor = (Doctor) person;
                System.out.println(doctor.toString());
            }
        }
        if (doctorCount == 0) {
            System.out.println("\u001B[31mNo doctors found.\u001B[0m");
        }
    }

    public static void viewPatients() {
        System.out.println("\n===== DISPLAY PATIENTS =====");

        int patientCount = 0;
        for (Person person : persons) {
            if (person instanceof Patient) {
                patientCount++;
                System.out.print("\n\tPatient " + patientCount);
                Patient patient = (Patient) person;
                System.out.println(patient.toString());
            }
        }
        if (patientCount == 0) {
            System.out.println("\u001B[31mNo patients found.\u001B[0m");
        }
    }

    public static void viewWardRooms() {
        System.out.println("\n===== DISPLAY WARD ROOMS =====");

        int wardRoomCount = 0;
        for (WardRoom wardRoom : wardRooms) {
            wardRoomCount++;
            System.out.println("\n\tWard Room " + wardRoomCount);
            System.out.println(wardRoom.toString());
        }
        if (wardRoomCount == 0) {
            System.out.println("\u001B[31mNo ward rooms found.\u001B[0m");
        }
    }

    public static void saveRecords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hospital_data.txt"))) {
            writer.write("======= HOSPITAL RECORD =======\n");
            writer.write("Date: " + currentDate + "\tDay: " + currentDate.getDayOfWeek() + "\n");

            writer.write("\n===== DOCTORS =====\n");
            int doctorCount = 0;
            for (Person person : persons) {
                if (person instanceof Doctor) {
                    doctorCount++;
                    writer.write("\n\tDoctor " + doctorCount);
                    Doctor doctor = (Doctor) person;
                    writer.write(doctor.toString() + "\n");
                }
            }
            if (doctorCount == 0) {
                writer.write("No doctors found.\n");
            }

            writer.write("\n===== PATIENTS =====\n");
            int patientCount = 0;
            for (Person person : persons) {
                if (person instanceof Patient) {
                    patientCount++;
                    writer.write("\n\tPatient " + patientCount);
                    Patient patient = (Patient) person;
                    writer.write(patient.toString() + "\n");
                }
            }
            if (patientCount == 0) {
                writer.write("No patients found.\n");
            }

            writer.write("\n===== WARD ROOMS =====\n");
            int wardRoomCount = 0;
            for (WardRoom wardRoom : wardRooms) {
                wardRoomCount++;
                writer.write("\n\tWard Room " + wardRoomCount);
                writer.write(wardRoom.toString() + "\n");
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

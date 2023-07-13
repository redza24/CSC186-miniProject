import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class HospitalApp{
    //used of 'static method' to share the used of scan and final modifier between static method
    //Scanner
    private static Scanner scan = new Scanner(System.in); //for other data types
    private static Scanner scan1 = new Scanner(System.in); //for String
    
    //constant
    //test value for each constant
    private static final int MAX_DOCTORS = 1;
    private static final int MAX_PATIENTS = 1;
    private static final int MAX_WARDROOMS = MAX_PATIENTS;
    
    //set the size of each array
    private static Person[] persons = new Person[MAX_PATIENTS + MAX_DOCTORS];
    private static WardRoom[] arrWardRooms = new WardRoom[MAX_WARDROOMS];

    //date purposes
    private static String dayNames[] = new DateFormatSymbols().getWeekdays(); //to return string of weekdays and store in array named dayNames
    private static Calendar calendar = Calendar.getInstance(); //to return calendar object
    private static LocalDate ld = LocalDate.now();// to display current date

    //main method where the selection begins
    public static void main(String[] args) {
        int choice = 0;
        while(choice != 10){
            System.out.println("===== Hospital Management System =====");
            System.out.println("Date: " + ld + "\tDay: " + dayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
            System.out.println();
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Assign Patient to Ward Room");
            System.out.println("4. View Doctor");
            System.out.println("5. View Patient");
            System.out.println("6. View Ward Room");
            System.out.println("7. Save Record");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            System.out.println();

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
                    viewDoctor();
                    break;
                case 5:
                    viewPatient();
                    break;
                case 6:
                    viewWardRoom();
                    break;
                case 7:
                    saveData();
                    break;
                case 8:
                    System.out.println("Thank you for using our services");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    System.out.println();
                    break;
            }
        }
    }

    //choice no.1: Add doctor
    public static void addDoctor() {
        for(int i = 0; i < persons.length - MAX_DOCTORS; i++) {
            System.out.println("<<<<<<<<<< ADD DOCTOR >>>>>>>>>>");
            System.out.print("Name: ");
            String name = scan1.nextLine().toUpperCase();
            System.out.print("Age: ");
            int age = scan.nextInt();
            System.out.print("Gender [M/F]: ");
            char gender = scan1.nextLine().toUpperCase().charAt(0);
            System.out.print("Specialization [general/specialist/surgeon]: ");
            String specialization = scan1.nextLine().toUpperCase();
            System.out.print("Availability [Y/N]: ");
            char availability = scan1.nextLine().toUpperCase().charAt(0);
            System.out.print("Contact Number [XXX-XXXXXXX]: ");
            String contactNum = scan1.nextLine().toUpperCase();
            System.out.print("Email: ");
            String email = scan1.nextLine().toUpperCase();

            //store onto object
            persons[i] = new Doctor(name, age, gender, specialization, availability, contactNum, email);
        }
        System.out.println("Data Stored Successfully");
        System.out.println();
    }

    //choice no.2: Add Patient
    public static void addPatient() {
        for(int i = 0; i < persons.length - MAX_PATIENTS; i++) {
            System.out.println("\n<<<<<<<<<< ADD PATIENT >>>>>>>>>>");
            System.out.print("Name: ");
            String name = scan1.nextLine().toUpperCase();
            System.out.print("Age: ");
            int age = scan.nextInt();
            System.out.print("Gender [M/F]: ");
            char gender = scan1.nextLine().toUpperCase().charAt(0);
            System.out.print("Diagnosis: ");    //to receive what kind of sickness patients are having
            String diagnosis = scan1.nextLine().toUpperCase();
            System.out.print("Admission Date [dd/mm]: ");
            String admissionDate = scan1.nextLine().toUpperCase();
            System.out.print("Discharge Date [dd/mm]: ");
            String dischargeDate = scan1.nextLine().toUpperCase();
            System.out.print("Insurance [true/false]: ");
            boolean insurance = scan.nextBoolean();
            //store onto object
            persons[i] = new Patient(name, age, gender, diagnosis, admissionDate, dischargeDate, insurance);
        }
        System.out.println("Data Stored Successfully");
        System.out.println();
    }

    //choice no.3: Add Ward Room
    public static void addWardRoom() {
        for (int i = 0; i < MAX_WARDROOMS; i++) {
            Random random = new Random(50); //random number for ward room
            System.out.println("<<<<<<<<<< ASSIGN PATIENT TO WARD ROOM >>>>>>>>>>");
            System.out.print("Patient Name: ");
            String nameCompare = scan1.nextLine().toUpperCase();
            int roomNum = 0;
            if(persons[i] instanceof Patient) {
                Patient pt = (Patient) persons[i];
                if(nameCompare.equalsIgnoreCase(pt.getName())) { //comparing name given to the name in object
                    System.out.print("Day being held in ward: ");
                    int heldWard = scan.nextInt();
                    System.out.print("Room Type [elite/basic]: ");
                    String roomType = scan1.nextLine().toUpperCase();
                    System.out.print("Enter deposit [min RM50]: ");
                    double deposit = scan.nextDouble();
                    if(roomType.equalsIgnoreCase("elite")) {
                        roomNum = random.nextInt(50);
                        System.out.print("Room Number: " + roomNum);
                        System.out.println();
                        String name = pt.getName();
                        int age = pt.getAge(); 
                        char gender = pt.getGender();
                        String diagnosis = pt.getDiagnosis();
                        String addmissionDate = pt.getAdmissionDate();
                        String dischargeDate = pt.getDischargeDate();
                        boolean insurance = pt.getInsurance();
                        //store onto object
                        arrWardRooms[i] = new WardRoom(roomType, roomNum, heldWard, deposit, name, age, gender, diagnosis, addmissionDate, dischargeDate, insurance);
                        System.out.println("Total Price: RM" + arrWardRooms[i].calcTotal() + "\n");
                    }
                    if(roomType.equalsIgnoreCase("basic")) {
                        roomNum = random.nextInt(50);
                        System.out.print("Room Number: " + roomNum);
                        System.out.println();
                        String name = pt.getName();
                        int age = pt.getAge(); 
                        char gender = pt.getGender();
                        String diagnosis = pt.getDiagnosis();
                        String addmissionDate = pt.getAdmissionDate();
                        String dischargeDate = pt.getDischargeDate();
                        boolean insurance = pt.getInsurance();
                        //store onto object
                        arrWardRooms[i] = new WardRoom(roomType, roomNum, heldWard, deposit, name, age, gender, diagnosis, addmissionDate, dischargeDate, insurance);
                        System.out.println("Total Price: RM" + arrWardRooms[i].calcTotal() + "\n");
                    }
                }
                else{
                    System.out.println("Invalid");
                    System.out.println();
                    addWardRoom(); //to ask the user to input the data correctly
                }
                System.out.println("data stored successfully");
            }
        }
    }

    //choice no.4: View Doctor
    public static void viewDoctor() {
        System.out.println("===== DISPLAY DOCTORS =====");
        System.out.println();
        for (int i = 0; i < MAX_DOCTORS; i++) {
           if(persons[i] instanceof Doctor) {
            Doctor dr = (Doctor) persons[i];
                if(dr == null || persons.length == 0) {
                    System.out.println("No Doctor Available");
                    return;
                }
            } 
        }
        for (int i = 0; i < persons.length - MAX_DOCTORS; i++) {
            System.out.println("DOCTOR " + (i+1));
            if(persons[i] instanceof Doctor){
                Doctor dr = (Doctor) persons[i];
                if(dr == null || persons.length == 0) {
                    System.out.println("No data");
                }
                else {
                    System.out.println(dr.toString());
                }
            }
            System.out.println();
        }
    }

    //choice no.5: View Patient
    public static void viewPatient() {
        System.out.println("===== DISPLAY PATIENTS =====");
        System.out.println();
        for (int i = 0; i < MAX_DOCTORS; i++) {
           if(persons[i] instanceof Patient) {
            Patient pt = (Patient) persons[i];
                if(pt == null || persons.length == 0) {
                    System.out.println("No Doctor Available");
                    return;
                }
            } 
        }
        for (int i = 0; i < persons.length - MAX_PATIENTS; i++) {
            System.out.println("PATIENT " + (i + 1));
            if(persons[i] instanceof Patient){
                Patient pt = (Patient) persons[i];
                if(pt == null || persons.length == 0) {
                    System.out.println("No data");
                }
                else {
                    System.out.println(pt.toString());
                }
            }
            System.out.println();
        }
    }

    //choice no.6: View Ward Room
    public static void viewWardRoom() {
        System.out.println("===== DISPLAY WARD ROOMS =====");
        System.out.println();

        if (arrWardRooms == null || arrWardRooms.length == 0) {
            System.out.println("No ward rooms available.");
            return;
        }

        for (int i = 0; i < MAX_WARDROOMS; i++) {
            System.out.println("WARD ROOM " + (i + 1));

            if (arrWardRooms[i] == null) {
                System.out.println("Ward room data is missing.");
            } 
            else {
                System.out.println(arrWardRooms[i].toString());
            }
            System.out.println();
        }
    }

    //choice no.7: Save to TXT file
    public static void saveData() {
        try {
            FileWriter fileWriter = new FileWriter("hospital_data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("======= HOSPITAL RECORD =======\n");
            bufferedWriter.write("\nDate: " + ld + "\tDay: " + dayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
            bufferedWriter.newLine();

            // Save doctors
            bufferedWriter.write("\n===== DOCTORS =====");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (int i = 0; i < MAX_DOCTORS; i++) {
                bufferedWriter.write("DOCTOR " + (i + 1));
                bufferedWriter.newLine();
                if(persons[i] instanceof Doctor) {
                    Doctor dr = (Doctor) persons[i];
                    if(dr == null) {
                        bufferedWriter.write("No Data\n");
                    }
                    else {
                        bufferedWriter.write(dr.toString() + "\n");
                    }
                }
                bufferedWriter.newLine();
            }

            // Save patients
            bufferedWriter.write("===== PATIENTS =====");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (int i = 0; i < MAX_PATIENTS; i++) {
                bufferedWriter.write("PATIENT " + (i + 1));
                bufferedWriter.newLine();
                if(persons[i] instanceof Patient) {
                    Patient pt = (Patient) persons[i];
                    if(pt == null || (persons.length - MAX_PATIENTS) == 0) {
                        bufferedWriter.write("No Data\n");
                    }
                    else {
                        bufferedWriter.write(pt.toString() + "\n");
                    }
                }
                bufferedWriter.newLine();
            }

            // Save ward rooms
            bufferedWriter.write("===== WARD ROOMS =====");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (int i = 0; i < MAX_WARDROOMS; i++) {
                bufferedWriter.write("WARD ROOM " + (i + 1));
                bufferedWriter.newLine();

                if (arrWardRooms[i] == null) {
                    bufferedWriter.write("No Data");
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(arrWardRooms[i].toString());
                    bufferedWriter.newLine();
                }

                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            System.out.println("Data saved successfully to hospital_data.txt");
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data to hospital_data.txt");
            System.out.println();
            e.printStackTrace();
        }
    }
}
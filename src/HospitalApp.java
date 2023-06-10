import java.util.*;
import java.io.*;
import java.time.*;
public class HospitalApp {
    //use 'static' to access data from other method
    //this is constant to set the limit for each input
    private static final int MAX_DOCTORS = 2; //test value for doctor is 2
    private static final int MAX_PATIENTS = 2; //test value for patient is 2
    private static final int MAX_WARDROOMS = 2; //test value for ward room is 2

    //set the size of array depends on constant
    private static Patient[] arrPatients = new Patient[MAX_PATIENTS];
    private static Doctor[] arrDoctor = new Doctor[MAX_DOCTORS];
    private static WardRoom[] arrWardRooms = new WardRoom[MAX_WARDROOMS];

    //obviously scanner for input
    private static Scanner scan = new Scanner(System.in);
    private static Scanner scan1 = new Scanner(System.in);

    //main method act like a bridge between one method to another
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();// to display current date
        
        int choice = 0;
        while(choice != 8){
            System.out.println("=== Hospital Management System === ");
            System.out.println("Date: " + ld);
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Assign Patient to Ward Room");
            System.out.println("4. Display All Doctors");
            System.out.println("5. Display All Patients");
            System.out.println("6. Display All Ward Rooms");
            System.out.println("7. Save Data to TXT File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            System.out.println();

            switch(choice){
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
                    displayDoctor();
                    break;
                case 5:
                    displayPatient();
                    break;
                case 6:
                    displayWardRoom();
                    break;
                case 7:
                    saveData();
                    break;
                case 8:
                    System.out.println("Thank you for using our services");
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    //to add data of doctor for that day
    public static void addDoctor() {
        for(int i = 0; i < MAX_DOCTORS; i++) {
            System.out.println("<<<<<<<<<< ADD DOCTOR >>>>>>>>>>");
            System.out.print("Name: ");
            String name = scan1.nextLine();
            System.out.print("Age: ");
            int age = scan.nextInt();
            System.out.print("Gender [M/F]: ");
            char gender = scan1.nextLine().charAt(0);
            System.out.print("Specialization: ");
            String specialization = scan1.nextLine();
            System.out.print("Availability [Y/N]: ");
            char availability = scan1.nextLine().charAt(0);
            System.out.print("Contact Number: ");
            String contactNum = scan1.nextLine();
            System.out.print("Email: ");
            String email = scan1.nextLine();

            //store onto object
            Doctor doctor = new Doctor(name, age, gender, specialization, availability, contactNum, email);
        }
        System.out.println("Data Stored Succesfully");
        System.out.println();
    }

    //to add data of patient for that day
    public static void addPatient() {
        for(int i = 0; i < MAX_PATIENTS; i++) {
            System.out.println("<<<<<<<<<< ADD PATIENT >>>>>>>>>>");
            System.out.print("Name: ");
            String name = scan1.nextLine();
            System.out.print("Age: ");
            int age = scan.nextInt();
            System.out.print("Gender [M/F]: ");
            char gender = scan1.nextLine().charAt(0);
            System.out.print("Diagnosis: ");    //to receive what kind of sickness patients are having
            String diagnosis = scan1.nextLine();
            System.out.print("Addmission Date: ");
            String addmissionDate = scan1.nextLine();
            System.out.print("Discharge Date: ");
            String dischargeDate = scan1.nextLine();

            //store onto object
            Patient patient = new Patient(name, age, gender, diagnosis, addmissionDate, dischargeDate);
        }
        System.out.println("Data Stored Succesfully");
        System.out.println();
    }

    public static void addWardRoom() {
        for(int i = 0; i < MAX_WARDROOMS; i++) {
            System.out.println("\t<<<<<<<<<< ASSIGN PATIENT TO WARD ROOM >>>>>>>>>>");
            System.out.print("Patient Name: ");
            String pName = scan1.nextLine();
            
            if (!pName.equalsIgnoreCase(arrPatients[i].getName())) {
                
            }
        }        
    }

    //Display all data about doctor that day
    public static void displayDoctor() {
        
    }

    //Display all data about patient that day
    public static void displayPatient() {
        
    }

    //Display all data about ward room that day
    public static void displayWardRoom() {
        
    }

    //Save all data to txt file
    public static void saveData() {
        
    }
}

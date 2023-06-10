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
            System.out.println("8. Exit app");
            System.out.println();
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
            arrDoctor[i] = doctor; //store into array
        }
        System.out.println("Data Stored Successfully");
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
            System.out.print("Admission Date: ");
            String admissionDate = scan1.nextLine();
            System.out.print("Discharge Date: ");
            String dischargeDate = scan1.nextLine();

            //store onto object
            Patient patient = new Patient(name, age, gender, diagnosis, admissionDate, dischargeDate);
            arrPatients[i] = patient; //store into array
        }
        System.out.println("Data Stored Successfully");
        System.out.println();
    }

    public static void addWardRoom() {
        for(int i = 0; i < MAX_WARDROOMS; i++) {
            System.out.println("\t<<<<<<<<<< ASSIGN PATIENT TO WARD ROOM >>>>>>>>>>");
            System.out.print("Room Number: ");
            String roomNum = scan1.nextLine();
            System.out.print("Patient Name: ");
            String pName = scan1.nextLine();
            int capacity = 0;
            int pAge = arrPatients[i].getAge();
            char pGender = arrPatients[i].getGender();
            final int occupiedCap = MAX_WARDROOMS;
            while(capacity <= occupiedCap) {
                if (pName.equalsIgnoreCase(arrPatients[i].getName())) {
                    System.out.println("<<<Assigning to Ward Room>>>");
                    arrPatients[i].getName().equalsIgnoreCase(pName);
                    capacity++;
                }
                else {
                    System.out.println("Invalid Patients");
                }
            }
            if (capacity == occupiedCap){
                System.out.println("Ward Room is fully occupied");
            }
            // Patient(pName, pAge,pGender);
            WardRoom wardRoom = new WardRoom(roomNum, capacity, occupiedCap, null);
        }
        System.out.println("Data Stored Successfully");
        System.out.println();        
    }

    //Display all data about doctor that day
    public static void displayDoctor() {
        System.out.println("<<< DISPLAY DOCTORS >>>");
        System.out.println();
        
        if (arrDoctor == null || arrDoctor.length == 0) {
            System.out.println("No doctors available.");
            return;
        }
        
        for (int i = 0; i < MAX_DOCTORS; i++) {
            System.out.println("DOCTOR " + (i+1));
            
            if (arrDoctor[i] == null) {
                System.out.println("Doctor data is missing.");
            } else {
                arrDoctor[i].toString();
            }
            
            System.out.println();
        }
    }

    //Display all data about patient that day
    public static void displayPatient() {
        System.out.println("<<< DISPLAY PATIENTS >>>");
        System.out.println();

        if (arrPatients == null || arrPatients.length == 0) {
            System.out.println("No patients available.");
            return;
        }

        for (int i = 0; i < MAX_PATIENTS; i++) {
            System.out.println("PATIENT " + (i + 1));

            if (arrPatients[i] == null) {
                System.out.println("Patient data is missing.");
            } else {
                arrPatients[i].toString();
            }

            System.out.println();
        }
    }

    //Display all data about ward room that day
    public static void displayWardRoom() {
        System.out.println("<<< DISPLAY WARD ROOMS >>>");
        System.out.println();

        if (arrWardRooms == null || arrWardRooms.length == 0) {
            System.out.println("No ward rooms available.");
            return;
        }

        for (int i = 0; i < MAX_WARDROOMS; i++) {
            System.out.println("WARD ROOM " + (i + 1));

            if (arrWardRooms[i] == null) {
                System.out.println("Ward room data is missing.");
            } else {
                arrWardRooms[i].toString();
            }

            System.out.println();
        }
    }
    
    //Save all data to txt file
    public static void saveData() {
        try {
            FileWriter fileWriter = new FileWriter("hospital_data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Save doctors
            bufferedWriter.write("<<< DOCTORS >>>");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (int i = 0; i < MAX_DOCTORS; i++) {
                bufferedWriter.write("DOCTOR " + (i + 1));
                bufferedWriter.newLine();
                
                if (arrDoctor[i] == null) {
                    bufferedWriter.write("Doctor data is missing.");
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(arrDoctor[i].toString());
                    bufferedWriter.newLine();
                }

                bufferedWriter.newLine();
            }

            // Save patients
            bufferedWriter.write("<<< PATIENTS >>>");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (int i = 0; i < MAX_PATIENTS; i++) {
                bufferedWriter.write("PATIENT " + (i + 1));
                bufferedWriter.newLine();

                if (arrPatients[i] == null) {
                    bufferedWriter.write("Patient data is missing.");
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(arrPatients[i].toString());
                    bufferedWriter.newLine();
                }

                bufferedWriter.newLine();
            }

            // Save ward rooms
            bufferedWriter.write("<<< WARD ROOMS >>>");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (int i = 0; i < MAX_WARDROOMS; i++) {
                bufferedWriter.write("WARD ROOM " + (i + 1));
                bufferedWriter.newLine();

                if (arrWardRooms[i] == null) {
                    bufferedWriter.write("Ward room data is missing.");
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

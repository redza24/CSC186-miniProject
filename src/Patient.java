import java.util.Scanner;

public class Patient extends Person {
    private String diagnosis;
    private String admissionDate;
    private String dischargeDate;
    private boolean insurance;

    //normal constructor
    public Patient(String name, int age, char gender, String diagnosis, String admissionDate, String dischargeDate, boolean insurance) {
        super(name, age, gender);
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.insurance = insurance;
    }

    //setter
    public void setPatient(String diagnosis, String admissionDate, String dischargeDate, boolean insurance) {
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.insurance = insurance;
    }

    //getter
    public String getDiagnosis() {return diagnosis;}
    public String getAdmissionDate() {return admissionDate;}
    public String getDischargeDate() {return dischargeDate;}
    public boolean getInsurance() {return insurance;}


    //processor
    // public double priceDeduction() {
    //     Scanner scan = new Scanner(System.in);
    //     double coverage = 0.0, total = 0.0;
    //     if(insurance == true) {

    //     }
    //     else{
    //         coverage = 100;
    //     }
    //     total = coverage/100;
    //     return total;
    // }

    //printer
    public String toString(){
        return "\nName: " + getName()
        + "\nAge: " + getAge()
        + "\nGender: " + getGender()
        + "\nDiagnosis: " + diagnosis
        + "\nAdmission Date: " + admissionDate
        + "\nDischarge Date: " + dischargeDate
        + "\nInsurance: " + insurance;
    }
}

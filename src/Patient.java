public class Patient extends Person {
    private String diagnosis;
    private String admissionDate;
    private String dischargeDate;

    //normal
    public Patient(String name, int age, char gender, String diagnosis, String admissionDate, String dischargeDate) {
        super(name, age, gender);
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    //setter
    public void setPatient(String diagnosis, String admissionDate, String dischargeDate) {
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    //getter
    public String getDiagnosis() {return diagnosis;}
    public String getAdmissionDate() {return admissionDate;}
    public String getDischargeDate() {return dischargeDate;}

    //printer
    public void dataPatient() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
    }
}

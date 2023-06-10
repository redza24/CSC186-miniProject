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
    @Override
    public String toString() {
        return "Patient [Name: " + getName() +
               ", Gender: " + getGender() +
               ", Diagnosis: " + getDiagnosis() +
               ", Admission Date: " + getAdmissionDate() +
               ", Discharge Date: " + getDischargeDate() + "]";
    }
}

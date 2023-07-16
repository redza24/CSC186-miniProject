public class Patient extends Person {
    private String diagnosis;
    private boolean insurance;

    //normal constructor
    public Patient(String name, int age, char gender, String diagnosis, boolean insurance) {
        super(name, age, gender);
        this.diagnosis = diagnosis;
        this.insurance = insurance;
    }

    //setter
    public void setPatient(String diagnosis, boolean insurance) {
        this.diagnosis = diagnosis;
        this.insurance = insurance;
    }

    //getter
    public String getDiagnosis() {return diagnosis;}
    public boolean getInsurance() {return insurance;}

    //printer
    public String toString(){
        return "\nName: " + getName()
            + "\nAge: " + getAge()
            + "\nGender: " + getGender()
            + "\nDiagnosis: " + diagnosis
            + "\nInsurance: " + insurance;
    }
}

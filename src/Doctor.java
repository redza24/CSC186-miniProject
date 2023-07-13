public class Doctor extends Person {
    private String specialization;
    private char availability;
    private String contactNum;
    private String email;

    //normal constructor
    public Doctor(String name, int age, char gender, String specialization, char availability, String contactNum, String email) {
        super(name, age, gender);
        this.specialization = specialization;
        this.availability = availability;
        this.contactNum = contactNum;
        this.email = email;
    }

    //mutator
    public void setDoctor(String specialization, char availability, String contactNum, String email) {
        this.specialization = specialization;
        this.availability = availability;
        this.contactNum = contactNum;
        this.email = email;
    }

    //accessor
    public String getSpecialization() {return specialization;}
    public char getAvailability() {return availability;}
    public String getContactNum() {return contactNum;}
    public String getEmail() {return email;}

    //printer
    public String toString(){
        return "\nName: " + getName()
        + "\nAge: " + getAge()
        + "\nGender: " + getGender()
        + "\nSpecialization: " + specialization
        + "\nAvailability: " + availability
        + "\nContact Number: " + contactNum
        + "\nEmail: " + email;
    }

}

public class Doctor extends Person {
    //instance variable/attributes
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
    public void dataDoctor() {
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Specialization: " + specialization);
        System.out.println("Availability: " + availability);
        System.out.println("Contact Number: " + contactNum);
        System.out.println("Email: " + email);
    }

}

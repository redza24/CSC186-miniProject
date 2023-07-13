public class WardRoom {
    private String roomType;
    private int roomNum;
    private int heldWard;
    private double deposit;
    private Patient patient;

    //normal constructor
    public WardRoom(String roomType, int roomNum, int heldWard, double deposit, String name, int age, char gender, String diagnosis, String admissionDate, String dischargeDate, boolean insurance) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.heldWard = heldWard;
        this.deposit = deposit;
        this.patient = new Patient(name, age, gender, diagnosis, admissionDate, dischargeDate, insurance);
    }

    //setter
    public void setWardRoom(String roomType, int roomNum, int heldWard, double deposit, String name, int age, char gender, String diagnosis, String admissionDate, String dischargeDate, boolean insurance) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.heldWard = heldWard;
        this.deposit = deposit;
        patient.setPatient(diagnosis, admissionDate, dischargeDate, insurance);
    }

    //getter
    public String getRoomType() {return roomType;}
    public int getRoomNum() {return roomNum;}
    public int getHeldWard() {return heldWard;}
    public double getDeposit() {return deposit;}
    public Patient getPatients() {return patient;}
    //processor
    public double calcTotal() {
        double price = 0.00;
        if(roomType.equalsIgnoreCase("elite")) {
            price = ((1500.00 * patient.priceDeduction()) - deposit) * getHeldWard();
        }
        else {
            price = ((300.00 * patient.priceDeduction()) - deposit) * getHeldWard();
        }
        return price;
    }
    //printer
    public String toString(){
        return patient.toString() + "\nRoom Type: " + roomType + "\nRoom Number: " + roomNum + "\nDay being held in ward: " + heldWard + "\nDeposit: RM" + deposit;
    }
}

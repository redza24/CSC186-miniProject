public class WardRoom {
    private String roomType;
    private int roomNum;
    private int heldWard;
    private double deposit;
    private double price;
    private Patient patient;

    //normal constructor
    public WardRoom(String roomType, int roomNum, int heldWard, double deposit, String name, int age, char gender, String diagnosis, boolean insurance) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.heldWard = heldWard;
        this.deposit = deposit;
        this.price = 0;
        this.patient = new Patient(name, age, gender, diagnosis, insurance);
    }

    //setter
    public void setWardRoom(String roomType, int roomNum, int heldWard, double deposit, double price, String name, int age, char gender, String diagnosis, boolean insurance) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.heldWard = heldWard;
        this.deposit = deposit;
        this.price = price;
        patient.setPatient(diagnosis, insurance);
    }

    public void setPrice(double coverage) {
        this.price = coverage;
    }

    //getter
    public String getRoomType() {return roomType;}
    public int getRoomNum() {return roomNum;}
    public int getHeldWard() {return heldWard;}
    public double getDeposit() {return deposit;}
    public double getPrice() {return price;}
    public Patient getPatients() {return patient;}

    //processor
    public double calcTotal(double coverage) {
        double price = 0.00;
        coverage = 1 - (coverage / 100);
        if(roomType.equalsIgnoreCase("elite")) {
            price = ((1500.00 * coverage) * getHeldWard()) - deposit;
        }
        else {
            price = ((300.00 * coverage) * getHeldWard()) - deposit;
        }
        return price;
    }

    //printer
    public String toString(){
        return patient.toString() + "\nRoom Type: " + roomType 
                                + "\nRoom Number: " + roomNum 
                                + "\nDay being held in ward: " + heldWard 
                                + "\nDeposit: RM" + deposit 
                                + "\nTotal Price: RM" + getPrice();
    }
}

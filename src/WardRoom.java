public class WardRoom {
    private String roomNum;
    private int capacity;
    private int occupiedCap;
    private Patient patient;

    //normal
    public WardRoom(String roomNum, int capacity, int occupiedCap, Patient patient) {
        this.roomNum = roomNum;
        this.capacity = capacity;
        this.occupiedCap = occupiedCap;
        this.patient = patient;
    }

    //setter
    public void setWardRoom(String roomNum, int capacity, int occupiedCap, Patient patient) {
        this.roomNum = roomNum;
        this.capacity = capacity;
        this.occupiedCap = occupiedCap;
        this.patient = patient;
    }

    //getter
    public String getRoomNum() {return roomNum;}
    public int getCapacity() {return capacity;}
    public int getOccupiedCap() {return occupiedCap;}
    public Patient getPatient() {return patient;}

    //printer
    @Override
    public String toString() {
        return "WardRoom [Room Number: " + getRoomNum() +
               ", Capacity: " + getCapacity() +
               ", Occupied Capacity: " + getOccupiedCap() +
               ", Assigned Patient: " + getPatient() + "]";
    }
}

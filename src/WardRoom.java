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
    public int capacity() {return capacity;}
    public int occupiedCap() {return occupiedCap;}
    public Patient patient() {return patient;}

    public String toString(){
        return "Room Number: " + roomNum + "\nCapacity: " + capacity + "\nOccupied Capacity" + occupiedCap;
    }
    public void dataWard() {
        System.out.println("Room Number: " + roomNum);
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupied Capacity: " + occupiedCap);
    }
}

package Model;

public class Client implements Comparable<Client>{
    private int arrivalTime;
    private int serviceTime;
    private int ID;
    public Client(int id, int arrivalTime, int serviceTime){
        this.ID = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getServiceTime() {
        return serviceTime;
    }
    public int getID() {
        return ID;
    }
    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String toString() {
        return "( " + ID + " - At: " + arrivalTime + ", St: " + serviceTime + " )";
    }
    public int compareTo(Client t) {
        if(this.arrivalTime-t.getArrivalTime() == 0){
            return this.ID - t.getID();
        }
        return this.arrivalTime-t.getArrivalTime();
    }
}
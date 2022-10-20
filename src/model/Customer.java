package model;

public class Customer {
    private String CID;
    private String PID;
    private String Name;
    private String address;
    private String DID;

    public Customer(String CID, String PID, String name, String address, String DID) {
        this.setCID(CID);
        this.setPID(PID);
        setName(name);
        this.setAddress(address);
        this.setDID(DID);
    }

    public Customer() {
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "CID='" + CID + '\'' +
                ", PID='" + PID + '\'' +
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                ", DID='" + DID + '\'' +
                '}';
    }
}

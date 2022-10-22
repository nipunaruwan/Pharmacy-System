package model;

public class Customer {
    private String CID;
    private String Name;
    private String address;
    private String DID;

    public Customer() {
    }

    public Customer(String CID, String name, String address, String DID) {
        this.setCID(CID);
        setName(name);
        this.setAddress(address);
        this.setDID(DID);
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
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
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                ", DID='" + DID + '\'' +
                '}';
    }
}

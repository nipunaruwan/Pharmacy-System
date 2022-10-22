package model;

public class Doctor {
 private String DID;
 private String Name;
  private String Address;
 private String Experiennce;

 public Doctor() {
 }

 public Doctor(String DID, String name, String address, String experiennce) {
  this.setDID(DID);
  setName(name);
  setAddress(address);
  setExperiennce(experiennce);
 }

 public String getDID() {
  return DID;
 }

 public void setDID(String DID) {
  this.DID = DID;
 }

 public String getName() {
  return Name;
 }

 public void setName(String name) {
  Name = name;
 }

 public String getAddress() {
  return Address;
 }

 public void setAddress(String address) {
  Address = address;
 }

 public String getExperiennce() {
  return Experiennce;
 }

 public void setExperiennce(String experiennce) {
  Experiennce = experiennce;
 }

 @Override
 public String toString() {
  return "Doctor{" +
          "DID='" + DID + '\'' +
          ", Name='" + Name + '\'' +
          ", Address='" + Address + '\'' +
          ", Experiennce='" + Experiennce + '\'' +
          '}';
 }
}

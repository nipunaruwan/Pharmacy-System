package model;

public class Payment {
    private String PID;
    private String CID;
    private String Productname;
    private String Bank;
    private String accountno;

    public Payment() {
    }

    public Payment(String PID, String CID, String productname, String bank, String accountno) {
        this.setPID(PID);
        this.setCID(CID);
        setProductname(productname);
        setBank(bank);
        this.setAccountno(accountno);
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PID='" + PID + '\'' +
                ", CID='" + CID + '\'' +
                ", Productname='" + Productname + '\'' +
                ", Bank='" + Bank + '\'' +
                ", accountno='" + accountno + '\'' +
                '}';
    }
}

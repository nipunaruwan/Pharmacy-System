package View.Tm;

public class OrderTm {
    private String OID;
    private String CID;
    private String DsID;
    private String DATE;
    private String TIME;

    public OrderTm() {
    }

    public OrderTm(String OID, String CID, String dsID, String DATE, String TIME) {
        this.setOID(OID);
        this.setCID(CID);
        setDsID(dsID);
        this.setDATE(DATE);
        this.setTIME(TIME);
    }

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getDsID() {
        return DsID;
    }

    public void setDsID(String dsID) {
        DsID = dsID;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OID='" + OID + '\'' +
                ", CID='" + CID + '\'' +
                ", DsID='" + DsID + '\'' +
                ", DATE='" + DATE + '\'' +
                ", TIME='" + TIME + '\'' +
                '}';
    }
}

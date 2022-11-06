package View.Tm;

public class OrderdetailsTm {
    private String  OID;
    private String  PCODE;
    private String CID;
    private String DATE;
    private String TIME;

    public OrderdetailsTm() {
    }

    public OrderdetailsTm(String OID, String PCODE, String CID, String DATE, String TIME) {
        this.setOID(OID);
        this.setPCODE(PCODE);
        this.setCID(CID);
        this.setDATE(DATE);
        this.setTIME(TIME);
    }

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getPCODE() {
        return PCODE;
    }

    public void setPCODE(String PCODE) {
        this.PCODE = PCODE;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
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
        return "Orderdetails{" +
                "OID='" + OID + '\'' +
                ", PCODE='" + PCODE + '\'' +
                ", CID='" + CID + '\'' +
                ", DATE='" + DATE + '\'' +
                ", TIME='" + TIME + '\'' +
                '}';
    }
}

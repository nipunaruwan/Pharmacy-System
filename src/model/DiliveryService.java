package model;

public class DiliveryService {
    private String DSID;
    private String DSNAME;

    public DiliveryService() {
    }

    public DiliveryService(String DSID, String DSNAME) {
        this.setDSID(DSID);
        this.setDSNAME(DSNAME);
    }

    public String getDSID() {
        return DSID;
    }

    public void setDSID(String DSID) {
        this.DSID = DSID;
    }

    public String getDSNAME() {
        return DSNAME;
    }

    public void setDSNAME(String DSNAME) {
        this.DSNAME = DSNAME;
    }

    @Override
    public String toString() {
        return "DiliveryService{" +
                "DSID='" + DSID + '\'' +
                ", DSNAME='" + DSNAME + '\'' +
                '}';
    }
}

package View.Tm;

public class ItemTm {
    private String PCODE;
    private String NAME;
    private String DISCRIPTION;
    private int QTY;
    private double PRICE;

    public ItemTm(String pid, String cid, String productname, String bank, String accountno) {
    }

    public ItemTm(String PCODE, String NAME, String DISCRIPTION, int QTY, double PRICE) {
        this.setPCODE(PCODE);
        this.setNAME(NAME);
        this.setDISCRIPTION(DISCRIPTION);
        this.setQTY(QTY);
        this.setPRICE(PRICE);
    }

    public String getPCODE() {
        return PCODE;
    }

    public void setPCODE(String PCODE) {
        this.PCODE = PCODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDISCRIPTION() {
        return DISCRIPTION;
    }

    public void setDISCRIPTION(String DISCRIPTION) {
        this.DISCRIPTION = DISCRIPTION;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "Item{" +
                "PCODE='" + PCODE + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DISCRIPTION='" + DISCRIPTION + '\'' +
                ", QTY=" + QTY +
                ", PRICE=" + PRICE +
                '}';
    }
}

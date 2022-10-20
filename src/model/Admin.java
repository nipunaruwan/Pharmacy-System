package model;



public class Admin {

        private String ADMINID;
        private String USERNAME;
        private String PASSWORD;


        public Admin() {
        }

        public Admin(String ADMINID, String USERNAME, String PASSWORD) {
                this.setADMINID(ADMINID);
                this.setUSERNAME(USERNAME);
                this.setPASSWORD(PASSWORD);
        }

        public String getADMINID() {
                return ADMINID;
        }

        public void setADMINID(String ADMINID) {
                this.ADMINID = ADMINID;
        }

        public String getUSERNAME() {
                return USERNAME;
        }

        public void setUSERNAME(String USERNAME) {
                this.USERNAME = USERNAME;
        }

        public String getPASSWORD() {
                return PASSWORD;
        }

        public void setPASSWORD(String PASSWORD) {
                this.PASSWORD = PASSWORD;
        }

        @Override
        public String toString() {
                return "Admin{" +
                        "ADMINID='" + ADMINID + '\'' +
                        ", USERNAME='" + USERNAME + '\'' +
                        ", PASSWORD='" + PASSWORD + '\'' +
                        '}';
        }
}

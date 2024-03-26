public class HDD {
    private int hddSize;
    private String hddSizeUnit;

    HDD(int hddSize) {
        this.hddSize = hddSize;
        this.hddSizeUnit = "GB";
    }
    
    public String printHddDetails() {
        return Integer.toString(hddSize) + " " + hddSizeUnit;
    }
}

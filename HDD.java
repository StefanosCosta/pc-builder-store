public class HDD {
    private float hddSize;
    private String hddSizeUnit;

    HDD(float hddSize) {
        this.hddSize = hddSize;
        this.hddSizeUnit = "GB";
    }
    
    public String printHddDetails() {
        return Float.toString(hddSize) + " " + hddSizeUnit;
    }
}

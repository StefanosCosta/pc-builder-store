import java.util.ArrayList;

public class Workstation extends PC {
    private String os;

    Workstation(int ram, float cpuFrequency, float screenSize,float hddSize, String os) {
        super(ram, cpuFrequency, screenSize, hddSize);
        this.os = os;
    }

    public ArrayList<String> printWorkStation() {
        ArrayList<String> details = getPCDetails();
        details.add("OS: " + os);
        return details;
    }
}

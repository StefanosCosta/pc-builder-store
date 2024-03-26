import java.util.ArrayList;

public class Workstation extends PC {
    private String os;

    Workstation(int ram, float cpuFrequency, float screenSize,int hddSize, String os) {
        super(ram, cpuFrequency, screenSize, hddSize);
        this.os = os;
    }
    Workstation(PCTower tower, PCScreen screen, HDD hdd, String os) {
        super(tower, screen,hdd);
        this.os = os;
    }

    public ArrayList<String> printWorkStation() {
        ArrayList<String> details = getPCDetails();
        details.add("OS: " + os);
        return details;
    }
}

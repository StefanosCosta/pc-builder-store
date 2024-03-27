import java.util.ArrayList;

/**
 * The Workstation class is inherits from pc as it is a pc with an operating system.
 * It contains 2 constructors for any possible future use
 */
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

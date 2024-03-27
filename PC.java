import java.util.ArrayList;


/**
 * The PC class contains a hard drive, a pc screen and a pc tower.
 */
public class PC {
    private HDD hdd;
    private PCScreen screen;
    private PCTower tower;

    PC(int ram, float cpuFrequency, float screenSize, int hddSize) {
        this.hdd = new HDD(hddSize);
        this.screen = new PCScreen(screenSize); 
        this.tower = new PCTower(ram, cpuFrequency);
    }

    PC(PCTower tower, PCScreen screen, HDD hdd) {
        this.hdd = hdd;
        this.screen = screen; 
        this.tower = tower;
    }

    public String printScreenSize() {
        return "Screen: " + screen.getScreenSize();
    }

    public String printHDDContents() {
        return "HDD: " + hdd.printHddDetails();
    }

    public ArrayList<String> printPCTower() {
        String ramDetails = tower.GetRamDetails();
        String cpuDetails = tower.GetCpuDetails();
        ArrayList<String> details = new ArrayList<>();
        details.add(ramDetails);
        details.add(cpuDetails);
        return details;
    }

    public ArrayList<String> getPCDetails() {
        ArrayList<String> details = new ArrayList<>();
        details = printPCTower();
        details.add(this.printHDDContents());
        details.add(this.printScreenSize());
        return details;
        
    }

}

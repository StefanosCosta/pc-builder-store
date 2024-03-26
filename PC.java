import java.util.ArrayList;

public class PC {
    private HDD hdd;
    private PCScreen screen;
    private PCTower tower;

    PC(int ram, float cpuFrequency, float screenSize, float hddSize) {
        // super(ram, cpuFrequency);
        this.hdd = new HDD(hddSize);
        this.screen = new PCScreen(screenSize); 
        this.tower = new PCTower(ram, cpuFrequency);
    }

    public String printScreenSize() {
        return "Screen: " + screen.getScreenSize();
    }

    public String printHDDContents() {
        return "HDD: " + hdd.printHddDetails();
    }
    public ArrayList<String> printPCTower() {
        String ramDetails = "RAM: " + tower.GetRamDetails();
        String cpuDetails = "CPU Clock: " + tower.GetCpuDetails();
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

public class PCTower {
    private int ramSize;
    private String ramUnits;
    private float cpuFrequency;
    private String cpuFrequencyUnits;

    PCTower(int ramSize, float cpuFrequency) {
        this.ramSize = ramSize;
        this.ramUnits = "GB";
        this.cpuFrequency = cpuFrequency;
        this.cpuFrequencyUnits = "GHz";
    }

    int GetRamSize() {
        return ramSize;
    }

    float GetCpuFrequency() {
        return cpuFrequency;
    }

    String GetRamDetails() {
        return "RAM: " + Integer.toString(ramSize) +  " " + ramUnits;
    }

    String GetCpuDetails() {
        return "CPU: " + Float.toString(cpuFrequency) +  " " + cpuFrequencyUnits;
    }
}

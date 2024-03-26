import java.util.HashMap;
import java.util.Scanner;

public class UI {
    Scanner scan = new Scanner(System.in);
    HashMap<Integer,String> osMap = new HashMap<>();

    UI() {
        osMap.put(1, "Windows");
        osMap.put(2, "Linux");
    }
    

    public void printGreeting() {
        System.out.println("Welcome to our PC Builder Store");
    }

    public void printOptions() {
        System.out.print("Select one of the following options by entering your choice on the screen\n" + //
                        "\t1. PC tower\n" + //
                        "\t2. PC screen\n" + //
                        "\t3. Personal Computer\n" + //
                        "\t4. Workstation\n");
    }

    public void invalidInput() {
        System.out.println("Invalid Input... Please try again");
    }

    public void invalidInputIntRange(int min, int max) {
        System.out.printf("Input must be between %i and %i", min, max);
    }

    public void invalidInputFloatRange(float min, float max) {
        System.out.printf("Input must be between %f and %f", min, max);
    }

    public int retrieveIntegerInputInRange(int min, int max) {
        int number = 0;
        while (true) {
            try {
                String response = scan.nextLine();
                number = Integer.parseInt(response);
                if (number >=min && number <= max) {
                    break;
                } else {
                    this.invalidInputIntRange(min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer");
            }
        }
        return number;
    }

    public float retrieveFloatInputInRange(float min, float max) {
        float number = 0;
        while (true) {
            try {
                String response = scan.nextLine();
                number = Float.parseFloat(response);
                if (number >=min && number <= max) {
                    break;
                } else {
                    this.invalidInputFloatRange(min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer");
            }
        }
        return number;
    }

    public static void enterScreenSize() {
        System.out.println("Input is invalid or out of range... Please try again");
    }

    public PCTower getPCTowerDetails() {
        int ram = 0;
        float cpuFrequency = 0;

        System.out.println("How much RAM would you like? (GB)");
        ram = retrieveIntegerInputInRange(4,96);
        System.out.println("Desired CPU clock? (GHz)");
        cpuFrequency = this.retrieveFloatInputInRange(0.866f,6.7f);
        PCTower tower = new PCTower(ram, cpuFrequency);
        return tower;
    }

    public PCScreen getPCScreenDetails() {
        float screenSize  = 0;

        System.out.println("Screen Size?");
        screenSize = retrieveFloatInputInRange(16, 42);
        PCScreen tower = new PCScreen(screenSize);
        return tower;
    }

    public PC getPCDetails() {
        PCTower tower = getPCTowerDetails();
        PCScreen screen = getPCScreenDetails();


        System.out.println("How much HDD storage would you like?");
		int hddSize = retrieveIntegerInputInRange(100, 2048);
        HDD hdd = new HDD(hddSize);

        PC pc = new PC(tower,screen,hdd);
        
        return pc;
    }

    public Workstation getWorkstationDetails() {
        PCTower tower = getPCTowerDetails();
        PCScreen screen = getPCScreenDetails();


        System.out.println("How much HDD storage would you like?");
		int hddSize = retrieveIntegerInputInRange(100, 2048);
        HDD hdd = new HDD(hddSize);

        System.out.print("Your desired operating system?\n "+
                         "\t 1: Windows" +
                         "\t 2: Linux");
        int osChoice  =  retrieveIntegerInputInRange(1,2);
        String os  = osMap.get(osChoice);

        Workstation  workstation= new Workstation(tower,screen,hdd,os);
        
        return workstation;
    }

}
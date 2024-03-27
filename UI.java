import java.util.HashMap;
import java.util.Scanner;

public class UI {
    private Scanner scan = new Scanner(System.in);
    private HashMap<Integer,String> osMap = new HashMap<>();

    // initialize map for operating Systems
    UI() {
        osMap.put(1, "Windows");
        osMap.put(2, "Linux");
    }
    
    // instruction and response functions:
    public void printGreeting() {
        System.out.println("Welcome to our PC Builder Store");
    }

    public void printOptions() {
        this.emptyLine();
        System.out.print("Select one of the following options by entering your choice on the screen\n" + //
                        "\t1. PC tower\n" + //
                        "\t2. PC screen\n" + //
                        "\t3. Personal Computer\n" + //
                        "\t4. Workstation\n");
        this.emptyLine();
    }

    public void printPCTowerComponents() {
        System.out.print("The PC Tower consists of\n" + //
                        "\t1. Memory Size (RAM) - integer\n" + //
                        "\t2. CPU Frequency - 2 d.p.\n");
        this.emptyLine();
    }
    public void printPCScreenComponents() {
        System.out.print("The PC Screen consists of\n" + //
                        "\t1. Screen Size (inches) - 1 d.p. \n");
        this.emptyLine();
    }
    
    public void printPCComponents() {
        System.out.print("The Personal Computer consists of\n" + //
        "\t1. Memory Size (RAM) - integer\n" + //
        "\t2. CPU Frequency - 2 d.p.\n" + //
        "\t3. Screen Size (inches) - 1 d.p. \n" + //
        "\t4. HDD Size (GB) - integer\n");
        this.emptyLine();
    }

    public void printWorkstationComponents() {
        System.out.print("The Workstation consists of\n" + //
        "\t1. Memory Size (RAM) - integer\n" + //
        "\t2. CPU Frequency - 2 d.p.\n" + //
        "\t3. Screen Size (inches) - 1 d.p. \n" + //
        "\t4. HDD Size (GB) - integer\n" + //
        "\t5. Operating System (Windows or Linux)\n");
        this.emptyLine();
    }

    public void exitQuestion() {
        System.out.println("Would you like to place another order? (y/n)");
    }

    private void invalidInput() {
        System.out.println("Invalid Input... Please try again");
    }

    private void emptyLine() {
        System.out.println("");
    }

    private void invalidInputIntRange(int min, int max) {
        System.out.printf("Input must be between %d and %d\n", min, max);
    }

    private void invalidInputFloatRange(float min, float max) {
        System.out.printf("Input must be between %f and %f\n", min, max);
    }

    // functions that retrieve data from console:
    public int retrieveIntegerInputInRange(int min, int max) {
        int number = 0;
        while (true) {
            try {
                String response = scan.nextLine();
                number = Integer.valueOf(response);
                
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

    public boolean retrieveYesOrNoAnswer() {
        boolean answer = false;
        while (true) {
            String response = scan.nextLine();
            if (response.equals("y")) {
                answer = true;
                break;
            } else if (response.equals("n")){
                break;
            } else {
                this.invalidInput();
            }
        }
        return answer;
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
                System.out.println("Input must be a decimal");
            }
        }
        return number;
    }

  
    // Component order processing functions:

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
                         "\t 1: Windows\n" +
                         "\t 2: Linux\n");
        int osChoice  =  retrieveIntegerInputInRange(1,2);
        String os  = osMap.get(osChoice);

        Workstation  workstation= new Workstation(tower,screen,hdd,os);
        
        return workstation;
    }

    // Order printing functions:

    public void printPCTowerOrder(PCTower tower) {
        this.emptyLine();
        System.out.println("Here are your order details:");
        System.out.println("1x PC Tower:");
        System.out.println(tower.GetRamDetails());
        System.out.println(tower.GetCpuDetails());
        this.emptyLine();
    }

    public void printPCScreenOrder(PCScreen screen) {
        this.emptyLine();
        System.out.println("Here are your order details:");
        System.out.println("1x Screen:");
        System.out.println(screen.getScreenSize());
        this.emptyLine();
    }

    public void printPCOrder(PC pc) {
        this.emptyLine();
        System.out.println("Here are your order details:");
        System.out.println("1x Personal Computer:");
        for (String i : pc.getPCDetails() ){
            System.out.println(i);
        }
        this.emptyLine();
    }


    public void printWorkstationOrder(Workstation workstation) {
        this.emptyLine();
        System.out.println("Here are your order details:");
        System.out.println("1x Workstation:");
        for (String i : workstation.printWorkStation() ) {
            System.out.println(i);
        }
        this.emptyLine();
    }

}
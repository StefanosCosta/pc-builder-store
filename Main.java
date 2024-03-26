import java.util.Scanner;

class Main {
	
    public static void main(String[] args){

		UI ui = new UI();
		ui.printGreeting();
		Scanner scan = new Scanner(System.in);

		while (true ){
			// System.Println("Welcome to PC builder");
			ui.printOptions();
			// UI.getUserInput()
			String response = scan.nextLine();
			int number = 0;

			while (true) {
				try {
					number = Integer.parseInt(response);
					if (number >=1 && number <= 4) {
						break;
					} else {
						ui.invalidInput();
					}
				} catch (NumberFormatException e) {
					System.out.println("Input must be an integer");
				}
			}

			switch(number) {
				case 1:
					PCTower tower = ui.getPCTowerDetails();
					System.out.println("Here are your order details");
					System.out.println("PC Tower");
					System.out.println(tower.GetRamDetails());
					System.out.println(tower.GetCpuDetails());
					break;
				case 2:
					PCScreen screen = ui.getPCScreenDetails();
					System.out.println("Here are your order details");
					System.out.println(screen.getScreenSize());
					break;

				case 3:
					PC pc = ui.getPCDetails();
					System.out.println("Here are your order details");
					System.out.println(pc.getPCDetails());
					break;

				case 4:
					Workstation workstation = ui.getWorkstationDetails();
					System.out.println("Here are your order details");
					System.out.println(workstation.getPCDetails());
					break;
			}
			number = 0;
			
        
			break;
		}
	
	}
}

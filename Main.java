class Main {
	
    public static void main(String[] args){

		UI ui = new UI();
		ui.printGreeting();

		while (true ){
			// ask for order choice
			ui.printOptions();
			int number = ui.retrieveIntegerInputInRange(1, 4);

			// process order choices
			switch(number) {
				case 1:
					ui.printPCTowerComponents();
					PCTower tower = ui.getPCTowerDetails();
					ui.printPCTowerOrder(tower);
					break;
				case 2:
					ui.printPCScreenComponents();
					PCScreen screen = ui.getPCScreenDetails();
					ui.printPCScreenOrder(screen);
					break;

				case 3:
					ui.printPCComponents();
					PC pc = ui.getPCDetails();
					ui.printPCOrder(pc);
					break;

				case 4:
					ui.printWorkstationComponents();
					Workstation workstation = ui.getWorkstationDetails();
					ui.printWorkstationOrder(workstation);
					break;
			}

			ui.exitQuestion();
			if (!ui.retrieveYesOrNoAnswer()) {
				break;
			}
		}
	}
}

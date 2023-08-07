package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApp {
	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.run();
	}

	public void run() {
		Scanner sc= new Scanner(System.in);
		AirField field = new AirField();
		ArrayList<Jet> jets = field.getJets();
		System.out.println("Welcome to the JetsApp ... trademark of SD");

		boolean choice = true;
		while (choice) {
			System.out.println("Please pick an option from the menu ");
			System.out.println();
			choice = menu(sc,jets);
		}
		
		
		sc.close();
	}

	public boolean menu(Scanner sc, ArrayList<Jet> jets ) {
		System.out.println("*********************************");
		System.out.println("*1. List fleet                  *");
		System.out.println("*2. Fly all jets                *");
		System.out.println("*3. View fastest jet            *");
		System.out.println("*4. View jet with longest range *");
		System.out.println("*5. Load all Cargo Jets         *");
		System.out.println("*6. Dogfight!                   *");
		System.out.println("*7. Add a passenger jet to Fleet*");
		System.out.println("*8. Remove a jet from Fleet     *");
		System.out.println("*9. Quit                        *");
		System.out.println("*********************************");
		String choice = sc.nextLine();
		return switchChoice(sc, jets, choice);
	}


	public void listFleet(ArrayList<Jet> jets) {
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(jets.get(i));
		}
	}

	public void flyAll(ArrayList<Jet> jets) {
		for (int i = 0; i < jets.size(); i++) {
			(jets.get(i)).fly();
			System.out.println();
		}

	}

	public void viewFastes(ArrayList<Jet> jets) {
		double fastest = 0;
		int iterator = 0;
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getSpeedInMPH() > fastest) {
				fastest = jets.get(i).getSpeedInMPH();
				iterator = i;
			}
		}

		System.out.println("The fastest jet is: " + jets.get(iterator));
	}

	public void longestRange(ArrayList<Jet> jets) {
		double longest = 0;
		int iterator = 0;
		for (int i = 0; i < jets.size(); i++) {
			double currentRange = jets.get(i).range();
			if (currentRange > longest) {
				longest = currentRange;
				iterator = i;
			}
		}
		
		System.out.println("The jet with the longest range is: " + jets.get(iterator));
		System.out.println("It has a range of " + String.format("%.2f",longest) + " miles before refueling.");
	}
	public void dogFight(ArrayList<Jet> jets) {
		FighterJet winner = null;
		int iterator = 0;
		double speed = 0;
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i) instanceof FighterJet) {
				FighterJet jet = (FighterJet) jets.get(i);
				jet.fight();
				if (jet.getSpeedInMPH() > speed) {
					winner = jet;
					iterator = i;
				}
					
				
			}
		}
		System.out.println(jets.get(iterator) + " is the winner of the battle of ... speed.");
	}
	public void loadCargo(ArrayList<Jet> jets) {
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i) instanceof CargoPlane) {
				CargoPlane jet = (CargoPlane) jets.get(i);
				jet.loadCargo();			
				System.out.println();
			}
		}
	}
	public void addJet(ArrayList<Jet> jets, Scanner sc) {
		String model;
		double speed;
		int range;
		long price;
		System.out.print("Please enter the model of the jet ");
		model = sc.next();
		System.out.print("Please enter the speed of the jet in MPH ");
		speed = sc.nextDouble();
		sc.nextLine();
		System.out.print("Please enter the flight range of the jet to the nearest whole number");
		range = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the price of the jet: ");
		price = sc.nextLong();
		sc.nextLine();
		System.out.println();
		jets.add(new PassengerJet(model,speed,range,price));
		System.out.println("You just added the jet: " + jets.get(jets.size() - 1));
	}
	public void removeJet(ArrayList<Jet> jets, Scanner sc) {
		int choice;
		System.out.println("Please enter the index of the jet you would like to remove");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + 1 + ". " + jets.get(i));
		}
		choice = sc.nextInt();
		sc.nextLine();
		choice -= 1;
		System.out.println("You have chosen to remove: " + jets.get(choice));
		jets.remove(choice);
	}
	public boolean switchChoice(Scanner sc, ArrayList<Jet> jets,String choice) {
		switch (choice) {
		case "1":
		case "List fleet":
		case "List":
		case "list fleet":
		case "list":
			listFleet(jets);
			return true;
		case "2":
		case "Fly all jets":
		case "fly all jets":
		case "Fly all":
		case "fly all":
			flyAll(jets);
			return true;
		case "3":
		case "View fastest jet":
		case "view fastest jet":
		case "fastest":
		case "fastest jet":
			viewFastes(jets);
			return true;
		case "4":
		case "View jet with longest range":
		case "view jet with longest range":
		case "longest range":
		case "longest":
			longestRange(jets);
			return true;
		case "5":
		case "Load all cargo jets":
		case "load all cargo jets":
		case "load cargo jets":
		case "load all":
			loadCargo(jets);
			return true;
		case "6":
		case "Dogfight!":
		case "dogfight!":
		case "dogfight":
		case "Dogfight":
			dogFight(jets);
			return true;
		case "7":
		case "Add a passenger jet to the fleet":
		case "add a passenger jet to the fleet":
		case "add jet":
			addJet(jets, sc);
			return true;
		case "8":
		case "Remove a jet from fleet":
		case "remove a jet from fleet":
		case "remove jet":
		case "remove":
			removeJet(jets, sc);
			return true;
		case "9":
		case "quit":
		case "QUIT":
		case "Quit":
			System.out.println("Thanks for using the JetApp \nThis is trademarked by SkillDistillery ;)");
			return false;
		default:
			System.out.println("Please enter a valid choice...");
			return true;
			
		
		
			
			
		
		
		}
	}
}

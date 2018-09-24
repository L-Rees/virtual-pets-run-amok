package pets_amok;

import java.util.Scanner;

public class AmokApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Shelter myShelter = new Shelter();

		System.out.println(
				"Welcome to Lisa's Shelter for Virtual Pets!\n\nThank you for volunteering to care for our pets, both robotic and organic.");
		System.out.println(
				"\n\nPlease choose from an option below, or type add if you'd like to add a basic list of pets.");
		String menuChoice = "";
		while (!menuChoice.equals("10")) {
			for (int x = 0; x < 3; x++) {
				System.out.println(myShelter.shelterStatus());
				System.out.println(myShelter.mainMenu);
				menuChoice = input.nextLine();
				if (menuChoice.equals("add")) {
					myShelter.importpets();
				} else if (menuChoice.equals("1")) {
					myShelter.feedAllOrganicPets();
				} else if (menuChoice.equals("2")) {
					myShelter.waterAllOrganicPets();
				} else if (menuChoice.equals("3")) {
					System.out.println("What kind of pet would you like to play with?\n");
					System.out.println(myShelter.typeMenu);
					String playChoice = input.nextLine();
					if (playChoice.equals("1")) {
						System.out.println(
								"Here is a list of all the robotic dogs in the shelter. \nEnter the name of the one you'd like to adopt.\n");
						System.out.println(myShelter.getRDogList());
					} else if (playChoice.equals("2")) {
						System.out.println(
								"Here is a list of all the organic dogs in the shelter. \nEnter the name of the one you'd like to adopt.\n");
						System.out.println(myShelter.getODogList());
					} else if (playChoice.equals("3")) {
						System.out.println(
								"Here is a list of all the robotic cats in the shelter. \nEnter the name of the one you'd like to adopt.\n");
					} else if (playChoice.equals("4")) {
						System.out.println(
								"Here is a list of all the organic cats in the shelter. \nEnter the name of the one you'd like to adopt.\n");
					}
					String playName = input.nextLine();
					myShelter.playWithPet(playName);
					System.out.println("You played with " + playName + " and made them very happy.");
				} else if (menuChoice.equals("4")) {
					myShelter.chargeAllRoboticPets();
				} else if (menuChoice.equals("5")) {
					myShelter.oilAllRoboticPets();
				} else if (menuChoice.equals("6")) {
					myShelter.cleanAllCages();
				} else if (menuChoice.equals("7")) {
					myShelter.cleanLitterbox();
				} else if (menuChoice.equals("8")) {
					System.out.println("What kind of pet would you like to admit?\n");
					System.out.println(myShelter.typeMenu);
					String typeChoice = input.nextLine();
					System.out.println("What is the pet's name?");
					String nameInput = input.nextLine();
					boolean validName = false;
					while (!validName) {
						if (myShelter.nameCheck(nameInput) == false) {
							validName = true;
						} else {
							System.out.println(
									"That name is already in use in the shelter. Please enter a different name.");
							nameInput = input.nextLine();
						}
					}
					System.out.println("Would you like to enter any stats for " + nameInput + "? (y/n)");
					String entryChoice = input.nextLine();
					int boredomEntry = 0;
					int wellBeingEntry = 0;
					int chargeEntry = 0;
					int rustEntry = 0;
					int hungerEntry = 0;
					int thirstEntry = 0;

					if (entryChoice.equals("y")) {
						System.out.println(
								"What is your pet's boredom level, on a scale of 1 to 10, with 10 being the most bored?");
						boredomEntry = input.nextInt();
						System.out.println(
								"What is your pet's level of well-being, on a scale of 1 to 10, with 10 being the most content and healthy?");
						wellBeingEntry = input.nextInt();
						if (typeChoice.equals("1") || typeChoice.equals("3")) {
							System.out.println(
									"What is your robotic animal's battery charge level, on a scale of 1 to 10, with 10 being fully charged?");
							chargeEntry = input.nextInt();
							System.out.println(
									"What is your robotic pet's rust level, on a scale of 1 to 10, with 10 being rusted solid?");
							rustEntry = input.nextInt();
						}
						if (typeChoice.equals("2") || typeChoice.equals("4")) {
							System.out.println(
									"What is your organic pet's level of hunger, on a scale of 1 to 10, with 10 being ravenous?");
							hungerEntry = input.nextInt();
							System.out.println(
									"What is your organic pet's level of thirst, on a scale of 1 to 10, with 10 being extremely thirsty?");
							thirstEntry = input.nextInt();
						}
						if (typeChoice.equals("1")) {
							myShelter.putRDog(nameInput,
									new RDog(nameInput, boredomEntry, wellBeingEntry, chargeEntry, rustEntry));
						} else if (typeChoice.equals("2")) {
							myShelter.putODog(nameInput,
									new ODog(nameInput, boredomEntry, wellBeingEntry, hungerEntry, thirstEntry));
						} else if (typeChoice.equals("3")) {
							myShelter.putRCat(nameInput,
									new RCat(nameInput, boredomEntry, wellBeingEntry, chargeEntry, rustEntry));
						} else if (typeChoice.equals("4")) {
							myShelter.putOCat(nameInput,
									new OCat(nameInput, boredomEntry, wellBeingEntry, hungerEntry, thirstEntry));
						}
					} else {
						if (typeChoice.equals("1")) {
							myShelter.putNamedRDog(nameInput);
						} else if (typeChoice.equals("2")) {
							myShelter.putNamedODog(nameInput);
						} else if (typeChoice.equals("3")) {
							myShelter.putNamedRCat(nameInput);
						} else if (typeChoice.equals("4")) {
							myShelter.putNamedOCat(nameInput);
						}
					}
				} else if (menuChoice.equals("9")) {
					System.out.println("What kind of pet would you like to adopt?");
					System.out.println(myShelter.typeMenu);
					String adoptChoice = input.nextLine();

					if (adoptChoice.equals("1")) {
						System.out.println(
								"Here is a list of all the robotic dogs in the shelter. \nEnter the name of the one you'd like to adopt.\n");
						System.out.println(myShelter.getRDogList());
					} else if (adoptChoice.equals("2")) {
						System.out.println(
								"Here is a list of all the organic dogs in the shelter. \nEnter the name of the one you'd like to adopt.\n");
						System.out.println(myShelter.getODogList());
					} else if (adoptChoice.equals("3")) {
						System.out.println(
								"Here is a list of all the robotic cats in the shelter. \nEnter the name of the one you'd like to adopt.\n");
					} else if (adoptChoice.equals("4")) {
						System.out.println(
								"Here is a list of all the organic cats in the shelter. \nEnter the name of the one you'd like to adopt.\n");
					}
					String nameChoice = input.nextLine();
					myShelter.adoptpet(nameChoice);
					System.out.println(nameChoice + " has been adopted and left the shelter! You have helped "
							+ myShelter.getAdoptedPetCount() + " pets find a new home.");
				}
				System.out.println("Please choose an option from the menu");

			}
			myShelter.tick();
			
		}

		System.out.println("Thank you for volunteering at Lisa's Shelter for Virtual Pets!\nYou have helped "
				+ myShelter.getAdoptedPetCount() + " pets find a new home.\nGoodbye!");
		System.exit(0);

		input.close();
	}

}

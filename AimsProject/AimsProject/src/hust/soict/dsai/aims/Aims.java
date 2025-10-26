package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;

public class Aims {
	static Scanner sc = new Scanner(System.in);
	static Cart anOrder;
	public static void main(String[] args) {
		anOrder = new Cart();
		anOrder.initializeStore();
		menuScreen();
	}
	
	public static void menuScreen() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("YOUR CART:");
			anOrder.showCart();
			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			System.out.println("Please proceed with the following actions: ");
			System.out.println("1. Add DVD to cart");
			System.out.println("2. Remove DVD from cart");
			System.out.println("3. Calculate total sum");
			System.out.println("4. Exit the program");
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				continue;
			}
			
			switch(choice) {
			case 1:
				int opt1;
				while (true) {
					System.out.println("-----------------------------------------------");
					anOrder.showStore();
					System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
					System.out.println("Please enter the index of the DVD you want to add (Enter 0 to go back)");
					try {
						opt1 = sc.nextInt();
						sc.nextLine();
					} catch (java.util.InputMismatchException e) {
						System.out.println("!!! Invalid option, please try again");
						sc.nextLine();
						continue;
					}
					if (opt1 > 0 && opt1 <= 10) {
						anOrder.addDigitalVideoDisc(opt1);
						break;
					}
					else if (opt1 == 0) {
						break;
					}
					else {
						System.out.println("!!! Index out of range, please try again");
					}
				}
				break;
			case 2:
				int opt2;
				while (true) {
					System.out.println("-----------------------------------------------");
					System.out.println("YOUR CURRENT CART:");
					boolean decision = anOrder.showCart();
					if (decision) {
						System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
						System.out.println("Please enter the index of the DVD you want to remove (Enter 0 to go back)");
						try {
							opt2 = sc.nextInt();
							sc.nextLine();
						} catch (java.util.InputMismatchException e) {
							System.out.println("!!! Invalid option, please try again");
							sc.nextLine();
							continue;
						}

						if (opt2 > 0 && opt2 <= Cart.qtyOrdered) {
							anOrder.removeDigitalVideoDisc(opt2);
							break;
						}
						else if (opt2 == 0) {
							break;
						}
						else {
							System.out.println("!!! Index out of range, please try again");
						}
					}
					else {
						System.out.println("Discs must be added to cart before removed");
						break;
					}
				}
				break;
			case 3:
				float cost = anOrder.totalCost();
				System.out.printf("Total cost: %.2f$\n", cost);
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("!!! Index out of range, please try again");
			}
		}
		while (true);
	}
	
	

}

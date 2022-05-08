package _06_Console_Store;

import java.util.Scanner;

import _02_Generics_Store.Candy;
import _02_Generics_Store.Cart;
import _02_Generics_Store.Cereal;
import _02_Generics_Store.Clothing;
import _02_Generics_Store.Toy;

public class ConsoleStore {

    /*
     * Write a program that simulates shopping in a store using the Scanner and
     * the classes in Generics_Store.
     * 
     * Note: You may need to modify existing code in Generics Store and/or add
     * additional items and pictures to fulfill all the requirements. You are
     * also free to add any additional methods or classes in Console Store that
     * might be helpful to you.
     * 
     * Requirements:
     * 
     * -Use Ternary operators in place of simple if/else statements and do-while
     * loops instead of while loops where appropriate.
     * 
     * - There should be at least four unique items the user can buy. These can
     * be food items, nonfood items or both.
     * 
     * - The user should have a stipend of money to spend and each item should
     * have its own price.
     * 
     * -The user should have the ability to add items to their cart, remove
     * items, view items or check out.
     * 
     * -The program should continue until the user chooses to check out.
     * 
     * -When the user checks out you should let them know if they do not have
     * enough money to purchase all their items and offer to put items back.
     * 
     * -If the user successfully purchases the items you should remove the
     * amount from their stipend, show them the pictures of what they bought and
     * print out a receipt showing their name, the individual prices of the
     * items and their total.
     */

    public static void main(String[] args) {
    	String keepShopping;
    	Scanner scanner = new Scanner(System.in);
    	Cart<Object> cart = new Cart<Object>();
    	
    	System.out.println("Enter the amount of money you have: ");
    	int money = scanner.nextInt();
    	int price = 0;
    	
    	do {
    		System.out.println("You can add ('add') an item ('candy', 'cereal', 'toy', 'clothes'), remove ('remove') an item, or view ('view') items. What would you like to do?: ");
    		String option = scanner.nextLine();
    		if(option.equalsIgnoreCase("add")) {
    			System.out.println("What would you like to add?");
    			String item = scanner.nextLine();
    			if(item.equalsIgnoreCase("candy")) {
    				cart.add(new Candy());
    				price += 1;
    			}
    			else if(item.equalsIgnoreCase("cereal")) {
    				cart.add(new Cereal());
    				price += 5;
    			}
    			else if(item.equalsIgnoreCase("toy")) {
    				cart.add(new Toy());
    				price += 10;
    			}
    			else { 
    				cart.add(new Clothing());
    				price += 15;
    			}
    		}
    		else if(option.equalsIgnoreCase("remove")) {
    			System.out.println("What index item do you want to remove? (Indexed at 0)");
    			int index = scanner.nextInt();
    			cart.remove(index);
    		}
    		else if(option.equalsIgnoreCase("view")) {
    			cart.showCart();
    		}
    		System.out.println("Would you like to keep shopping? (y/n)");
    		keepShopping = scanner.nextLine();
    		if(price > money) {
    			System.out.println("You have spent too much. Remove an item and come back.");
    			keepShopping = "";
    		}
    	} while(keepShopping.equals("y"));
    	
    	money -= price;
    	cart.showCart();
    	System.out.println("Money left: " + money);
    	
    	
    	scanner.close();
    }

}

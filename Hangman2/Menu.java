import java.util.Scanner;

public class Menu {
	public static void main(String[]args){
		
		Menu me = new Menu();
		me.mainMenu();
	}

	public void mainMenu() {
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.print("Enter a command, > for help\n>");
			String option = keyboard.nextLine();
			String input = option.toLowerCase();
			switch (input) {
			default:
				System.out.println("? for help");
				break;

			case "?":
			case "help":
				System.out.println("Quit\nSomething\nCount");
				break;
			case "quit":
				quit = true;
				break;	
			case "game":
				Game go = new Game();
				
				}
				
				
				

				
			}
		}
	}



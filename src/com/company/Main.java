package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    boolean firstGame = true;
	System.out.println("Hello and welcome to our game of rock paper scissors");
	menu();
	SetupGame(firstGame);
    }

    public static void SetupGame(boolean isFirst)
    {
        if (isFirst) {
            //Go straight to create player
        }
        else {
            //ShowMenu();
        }
    }

    public static void menu(){
        Scanner menuScanner = new Scanner(System.in);
        System.out.println("\n" +
                "======== Rock Paper Scissors Game ========" +
                "\n" +
                "\n\t(1) Create a new player" +
                "\n\t(2) Select Players for new game" +
                "\n\t(3) View Player stats"+
                "\n\t(4) EXIT ");
        String menuSelect = menuScanner.nextLine();
        switch (menuSelect){
            case "1":
                // run create player function
                System.out.println("Player Created");
                Main.menu();
                break;
            case "2":
                // run select player function
                System.out.println("Player Selection Ran");
                Main.menu();
                break;
            case "3":
                //run Player Stats function
                System.out.println("Player Stats Displayed");
                Main.menu();
                break;
            case "4":
                System.out.println("Good-Bye!");
                System.exit(0);
                Main.menu();
                break;
            default:
                System.out.println("Invalid selection - Try Again: \n");
                Main.menu();
            Main.menu();
        }


    }

}

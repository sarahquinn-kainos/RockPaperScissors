package com.company;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {
    boolean firstGame = true;
	System.out.println("Hello and welcome to our game of rock paper scissors");
	setupGame(firstGame);
    }

    public static void setupGame(boolean isFirst) {
        if (isFirst) {
            System.out.println("Please input Player 1\'s desired username");
            Scanner setupScanner = new Scanner(System.in);
            String username = setupScanner.nextLine();
            System.out.println("Please input Player 2\'s desired username");
            String username2 = setupScanner.nextLine();
            Player player1 = new Player(username,0,0);
            Player player2 = new Player(username2,0,0);
            //startGame(player1,player2);//This method will also be used after players are selected
            players.add(player1);
            players.add(player2);


        }
        else {
            menu();
        }
    }
  
    public static void CreatePlayer()
    {
        System.out.println("Please input your desired username");
        Scanner usernameScanner = new Scanner(System.in);
        String username = usernameScanner.nextLine();
        Player player = new Player(username,0,0);
        players.add(player);
        //menu();

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
                showStats();

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

    public static void showStats(){
        System.out.println("\n" +
                "========== Player Stats ==========" +
                "\n <Username>    <Wins>   <Losses>" +
                "\n==================================");
        for (int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).userName +"         " +
                    players.get(i).currentWins +"         " +
                    players.get(i).currentLosses);
        System.out.println("==================================");

        }
    }

}

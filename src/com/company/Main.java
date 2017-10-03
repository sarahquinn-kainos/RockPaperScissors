package com.company;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static ArrayList<Player> players = new ArrayList<Player>();
    public static Player player1 = new Player();
    public static Player player2 = new Player();

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
            player1 = new Player(username, 0, 0);
            player2 = new Player(username2, 0, 0);
            players.add(player1);
            players.add(player2);
            startGame(player1,player2);//This method will also be used after players are selected

        } else {
            menu();
        }
    }

    public static void CreatePlayer() {
        System.out.println("Please input your desired username");
        Scanner usernameScanner = new Scanner(System.in);
        String username = usernameScanner.nextLine();

        for (Player player :
                players) {
            if (player.userName.equals(username)){
                System.out.println("Error. This username already exists");
                menu();
            }
        }
        Player myPlayer = new Player(username,0,0);

        players.add(myPlayer);
    }

    public static void menu() {
        Scanner menuScanner = new Scanner(System.in);
        System.out.println("\n" +
                "======== Rock Paper Scissors Game ========" +
                "\n" +
                "\n\t(1) Create a new player" +
                "\n\t(2) Select Players for new game" +
                "\n\t(3) View Player stats" +
                "\n\t(4) EXIT ");
        String menuSelect = menuScanner.nextLine();
        switch (menuSelect) {
            case "1":
                // run create player function
                CreatePlayer();
                Main.menu();
                break;
            case "2":
                // run select player function
                selectPlayer1();
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

    public static void selectPlayer1() {
        System.out.println("Please select the number corresponding to player 1\'s username");
        for (int i = 0; i < players.size(); i++) {
            String message = String.format("Player " + i + ": " + players.get(i).userName);
            System.out.println(message);
        }
        int selection = 0;
        Scanner selectScanner = new Scanner(System.in);
        if (isInteger(selectScanner.next())) {
            selection = selectScanner.nextInt();
        } else {
            System.out.println("Error. Please input a valid number");
            selectPlayer1();
        }
        if (players.get(selection) != null) {
            player1 = players.get(selection);
            selectPlayer2();
        } else {
            System.out.println("Error. Please input a valid number");
            selectPlayer1();
        }
    }

    public static void selectPlayer2() {
        System.out.println("Great! Now please select the number corresponding to player 2\'s username");
        for (int i = 0; i < players.size(); i++) {
            String message = String.format("Player " + i + ": " + players.get(i).userName);
            System.out.println(message);
        }
        int selection = 0;
        Scanner selectScanner = new Scanner(System.in);
        if (isInteger(selectScanner.next())) {
            selection = selectScanner.nextInt();
        } else {
            System.out.println("Error. Please input a valid number");
            selectPlayer2();
        }
        if (players.get(selection) != null) {
            if (!players.get(selection).userName.equals(player1.userName)) {
                player2 = players.get(selection);
                startGame(player1,player2);
            }
            else {

                System.out.println("Error. You can't play against yourself! get a friend");
                selectPlayer2();
            }

        } else {
            System.out.println("Error. Please input a valid number");
            selectPlayer2();
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static void showStats() {
        System.out.println("\n" +
                "========== Player Stats ==========" +
                "\n <Username>    <Wins>   <Losses>" +
                "\n==================================");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).userName + "         " +
                    players.get(i).currentWins + "         " +
                    players.get(i).currentLosses);

        System.out.println("==================================");
        }
    }

    public static void startGame(Player player1,Player player2) {
        int player1Choice = gameOptions(player1.userName);
        int player2Choice = gameOptions(player2.userName);

        if (player1Choice == player2Choice) {
            startGame(player1,player2);
            System.out.println("Oh! It's a draw! Play again!");
            if (player1Choice > player2Choice || (player1Choice == 1 && player2Choice == 3)) {
                playerWins(player1);
                playerLoses(player2);
            }
            else {
                playerWins(player2);
                playerLoses(player1);
            }
        }
        setupGame(false);
    }

    public static int gameOptions(String name) {
        System.out.println("\n" +
                "\n==================================" +
                "\n\n\n\n\n\n\n\n USER = " + name +
                "\n==== Select a numbered option ====" +
                "\n\t(1) ROCK" +
                "\n\t(2) PAPER" +
                "\n\t(3) SCISSORS" +
                "\n==================================");
        Scanner optionScanner = new Scanner(System.in);
        String option = optionScanner.nextLine();

            if (option== "1") {
                return (1);
            }

            if (option== "2") {
                return (2);
            }

            if (option== "3") {
                return (3);
            }

            if (option !="1" ||option !="2" ||option !="3"){
                System.out.println("\n Invalid Selection. TRY AGAIN");
                System.out.println("==================================");
                startGame(player1,player2);
                return (0);
        } return(0);
    }

    public static void playerWins(Player player) {
        System.out.println("Congratulations! " + player.userName +" You won");
        player.currentWins++;
    }

    public static void playerLoses(Player player) {
        System.out.println("Sorry! " + player.userName +" You Lost");
        player.currentLosses++;
    }
}


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
        }
        else {
            //menu();
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
}

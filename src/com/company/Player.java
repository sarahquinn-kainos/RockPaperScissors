package com.company;

public class Player {
    public String userName;
    public int currentWins;
    public int currentLosses;

    public Player(){

    }

    public Player(String userName, int currentWins, int currentLosses) {
        this.userName = userName;
        this.currentWins = 0;
        this.currentLosses = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCurrentWins() {
        return currentWins;
    }

    public void setCurrentWins(int currentWins) {
        this.currentWins = currentWins;
    }

    public int getCurrentLosses() {
        return currentLosses;
    }

    public void setCurrentLosses(int currentLosses) {
        this.currentLosses = currentLosses;
    }
}



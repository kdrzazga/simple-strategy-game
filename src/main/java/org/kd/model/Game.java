package org.kd.model;

public abstract class Game {

    public Player redPlayer;
    public Player bluePlayer;

    private long currentTurn;

    public void nextTurn(){
        currentTurn++;
    }
}

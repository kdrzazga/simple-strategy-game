package org.kd.model;

import org.kd.model.orders.Order;
import org.kd.view.TextCommandExecutor;

public class Game {

    public Player redPlayer;
    public Player bluePlayer;

    private Output output;
    private Input input;
    private CommandExecutor commandExecutor;

    public Board board;

    private long currentTurnNumber;
    private Player turn;

    public Game(Input input, Output output){
        board = new BoardFactory().createBalancedBoard();
        this.input = input;
        this.output = output;
        this.commandExecutor = new TextCommandExecutor(this, output);
    }

    public void draw(){
        output.draw(board);
    }
    public void nextTurn(){
        currentTurnNumber++;
    }

    public void start(){
        this.currentTurnNumber = 0;
        this.turn = Player.RED;

        draw();

        Order order = Order.END;
        while (!order.equals(Order.EXIT)){

            order = input.readOrder();
            commandExecutor.execute(order);
        }

        output.log("Good bye !");
        System.exit(0);
    }

    public long getCurrentTurnNumber() {
        return currentTurnNumber;
    }

    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public Output getOutput() {
        return output;
    }
}

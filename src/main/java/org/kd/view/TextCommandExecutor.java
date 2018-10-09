package org.kd.view;

import org.kd.model.BoardField;
import org.kd.model.CommandExecutor;
import org.kd.model.Game;
import org.kd.model.Output;
import org.kd.model.game_objects.Unit;
import org.kd.model.orders.Order;

import java.util.List;

public class TextCommandExecutor implements CommandExecutor {

    private final Output output;
    private Game game;
    private CommandParser parser;
    private Order order;

    public TextCommandExecutor(Game game, Output output) {
        this.game = game;
        this.output = output;
    }

    public void execute(Order order) {
        parser = new CommandParser(order.toString());
        parser.parse();

        if (!parser.validateCommand()) {
            output.log(TextOutputColors.RED_COLOR + "Wrong command" + TextOutputColors.END_COLOUR);
            return;
        }

        if (!parser.validateArguments()) {
            output.log(TextOutputColors.RED_COLOR + "Wrong arguments for command "
                    + parser.getCommand()
                    + TextOutputColors.END_COLOUR);
            return;
        }

        switch (order) {
            case END:
                executeEnd();
                break;
            case MOVE:
                executeMove(order.getArguments());
                break;
            case HELP:
                output.printHelp();
                break;
            case BUILD:
                executeBuild(order.getArguments());
                break;
            case RECRUIT:
                executeRecruit(order.getArguments());
                break;
            case STATUS:
                executeStatus(order.getArguments());
                break;
        }
    }

    private void executeEnd() {
        game.nextTurn();
    }


    private void executeMove(List<String> arguments) {
        Unit unit;
        BoardField destination;// = new BoardField(arguments.get(1));
        //order = new OrderMove(unit, destination);
    }

    private void executeBuild(List<String> arguments) {
    }

    private void executeRecruit(List<String> arguments) {
    }

    private void executeStatus(List<String> arguments) {
       // BoardField location = new BoardField(arguments.get(0));
       // output.printStatus(this.game.board, location);
    }

    public Game getGame() {
        return game;
    }
}

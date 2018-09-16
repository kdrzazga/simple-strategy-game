package org.kd.view;

import org.kd.model.BoardField;
import org.kd.model.Game;
import org.kd.model.game_objects.Unit;
import org.kd.model.orders.Order;

import java.io.PrintStream;
import java.util.List;

public class CommandExecutor {

    private final PrintStream out;
    private Game game;
    private CommandParser parser;
    private Order order;

    public CommandExecutor(Game game, PrintStream out) {
        this.game = game;
        this.out = out;
    }

    public void execute(String order) {
        parser = new CommandParser(order);
        parser.parse();

        if (!parser.validateCommand()) {
            out.print(TextOutputColors.RED_COLOR + "Wrong command" + TextOutputColors.END_COLOUR);
            return;
        }

        if (!parser.validateArguments()) {
            out.print(TextOutputColors.RED_COLOR + "Wrong arguments for command "
                    + parser.getCommand()
                    + TextOutputColors.END_COLOUR);
            return;
        }

        switch (parser.getCommand()) {
            case "end":
                executeEnd();
                break;
            case "move":
                executeMove(parser.getArguments());
                break;
            case "help":
                executeHelp();
                break;
            case "build":
                executeBuild(parser.getArguments());
                break;
            case "recruit":
                executeRecruit(parser.getArguments());
                break;
            case "status":
                executeStatus(parser.getArguments());
                break;
        }
    }

    private void executeEnd() {
        game.nextTurn();
    }

    private void executeHelp() {
        out.println("Unit symbol: r - red  b - blue");
        out.println("             P - peasant A - archer S - swordsman k - knight");
        out.println("             number - id of a unit");
        out.println("             rA1 - Red Archer with id=1");
        out.println();
        out.print("Available orders: ");
        CommandParser.getAvailableCommands().forEach(key -> out.print(key + " "));
        out.println();
        out.println("Examples: move 001aa, 005ac");
        out.println("          build bP2, barracks");
        out.println("          build rP1, field");
        out.println("          status bK3");
    }

    private void executeMove(List<String> arguments) {
        Unit unit;
        BoardField destination = new BoardField(arguments.get(1));
        //order = new OrderMove(unit, destination);
    }

    private void executeBuild(List<String> arguments) {
    }

    private void executeRecruit(List<String> arguments) {
    }

    private void executeStatus(List<String> arguments) {
    }

    public Game getGame() {
        return game;
    }
}

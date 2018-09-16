package org.kd.view;

import org.kd.model.Game;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CommandExecutorTest {

    @Test
    public void testExecutorForHelp(){
        Game game = new Game(new TextOutput());
        game.start();

        game.nextTurn();
        CommandExecutor executor = new CommandExecutor(game, System.out);

        executor.execute("end ");
        executor.execute("  end");

        assertEquals(game.getCurrentTurnNumber(), 3);
    }
}

package org.kd.view;

import org.kd.model.Game;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextCommandExecutorTest {

    @Test
    public void testExecutorForHelp(){
        FakeTextInput fakeInput = new FakeTextInput();
        Game game = new Game(fakeInput, new TextOutput());

        fakeInput.readOrder("end");

        game.start();

        game.nextTurn();
        TextCommandExecutor executor = new TextCommandExecutor(game, new TextOutput());

        //executor.execute("end ");
        //executor.execute("  end");

        assertEquals(game.getCurrentTurnNumber(), 3);
    }
}

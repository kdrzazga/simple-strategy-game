package org.kd.view;

import org.kd.model.Game;
import org.kd.model.orders.Order;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextCommandExecutorTest {

    @Test
    public void testExecutorForHelp(){
        var fakeInput = new FakeTextInput();
        var game = new Game(fakeInput, new TextOutput());

        fakeInput.readOrder("end");

        game.start();

        game.nextTurn();
        var executor = new TextCommandExecutor(game, new TextOutput());

        executor.execute(Order.END);
        executor.execute(Order.END);

        assertEquals(game.getCurrentTurnNumber(), 3);
    }
}

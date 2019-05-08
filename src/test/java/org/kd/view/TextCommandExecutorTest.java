package org.kd.view;

import org.junit.Before;
import org.junit.Test;
import org.kd.lib.exceptions.ExitTrappedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.kd.lib.SystemExitControl;
import org.kd.model.Game;
import org.kd.model.orders.Order;

public class TextCommandExecutorTest {

    @Mock
    private TextInput fakeTextInput;

    private final ByteArrayOutputStream newSystemOutputByteArray = new ByteArrayOutputStream();
    private final PrintStream oldSystemOutput = System.out;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecutionOfCommands() {
        System.setOut(new PrintStream(newSystemOutputByteArray));

        try {
            SystemExitControl.forbidSystemExitCall(); //Order.EXIT causes JVM to stop, it needs to be intercepted not to stop the test execution
            executeActionsInGame();

        } catch (ExitTrappedException e) {
            oldSystemOutput.println("Forbidding call to System.exit");
        }

        restoreDefaultSettings();

        assertTrue(newSystemOutputByteArray.toString().contains("Wrong command"));
        assertTrue(newSystemOutputByteArray.toString().contains("Unit symbol"));
        assertTrue(newSystemOutputByteArray.toString().contains("Wrong arguments for command status"));
        assertTrue(newSystemOutputByteArray.toString().contains("Good bye!"));
    }

    @Test
    public void test1(){
        System.setOut(new PrintStream(newSystemOutputByteArray));

        try {
            SystemExitControl.forbidSystemExitCall(); //Order.EXIT causes JVM to stop, it needs to be intercepted not to stop the test execution
            executeActionsInGame();

        } catch (ExitTrappedException e) {
            oldSystemOutput.println("Forbidding call to System.exit");
        }

        restoreDefaultSettings();
    }

    private void restoreDefaultSettings() {
        SystemExitControl.enableSystemExitCall();
        System.out.flush();
        System.setOut(oldSystemOutput);
    }

    private void executeActionsInGame() {
        var game = new Game(fakeTextInput, new TextOutput());

        when(fakeTextInput.readOrder())
                .thenReturn(Order.END)
                .thenReturn(Order.NULL)
                .thenReturn(Order.HELP)
                .thenReturn(Order.STATUS)
                .thenReturn(Order.EXIT);

        game.start();
    }
}

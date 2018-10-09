package org.kd.view;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CommandParserTest {

    private final String moveCommand = "move 1a01, 2g07";
    private final String recruitCommand = "recruit barracks1, archer";
    private final String statusCommand = "status barracks1";
    private final String endCommand = " end ";
    private final String fakeCommand = "Litwo Ojczyzno moja ";

    @Test
    public void testParsingCommand() {
        CommandParser parser = new CommandParser(moveCommand);
        parser.parse();
        assertEquals(parser.getCommand().toString(), "move");

        parser = new CommandParser(recruitCommand);
        parser.parse();
        assertEquals(parser.getCommand().toString(), "recruit");

        parser = new CommandParser(statusCommand);
        parser.parse();
        assertEquals(parser.getCommand().toString(), "status");
    }

    @Test
    public void testParsingArguments() {
        CommandParser parser = new CommandParser(moveCommand);
        parser.parse();
        assertTrue(parser.validateArguments());

        parser = new CommandParser(statusCommand);
        parser.parse();
        assertTrue(parser.validateArguments());
    }

    @Test
    public void testCommandValidation() {
        CommandParser parser = new CommandParser(fakeCommand);
        parser.parse();
        assertFalse(parser.validateCommand());

        parser = new CommandParser(recruitCommand);
        parser.parse();
        assertTrue(parser.validateCommand());
    }
}

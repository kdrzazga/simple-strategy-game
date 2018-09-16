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
        assertEquals(parser.getCommand(), "move");

        parser = new CommandParser(recruitCommand);
        parser.parse();
        assertEquals(parser.getCommand(), "recruit");

        parser = new CommandParser(statusCommand);
        parser.parse();
        assertEquals(parser.getCommand(), "status");
    }

    @Test
    public void testParsingArgumentsSize() {
        CommandParser parser = new CommandParser(moveCommand);
        parser.parse();
        assertEquals(parser.getArguments().size(), 2);

        parser = new CommandParser(statusCommand);
        parser.parse();
        assertEquals(parser.getArguments().size(), 1);

        parser = new CommandParser(endCommand);
        parser.parse();
        assertEquals(parser.getArguments().size(), 0);
    }

    @Test
    public void testParsingArguments() {
        CommandParser parser = new CommandParser(moveCommand);
        parser.parse();
        assertTrue(parser.getArguments().contains("1a01"));
        assertTrue(parser.getArguments().contains("2g07"));

        parser = new CommandParser(statusCommand);
        parser.parse();
        assertTrue(parser.getArguments().contains("barracks1"));
    }

    @Test
    public void testCommandValidation(){
        CommandParser parser = new CommandParser(fakeCommand);
        parser.parse();
        assertFalse(parser.validateCommand());

        parser = new CommandParser(recruitCommand);
        parser.parse();
        assertTrue(parser.validateCommand());
    }
}

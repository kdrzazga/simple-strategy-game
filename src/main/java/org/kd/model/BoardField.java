package org.kd.model;

import java.util.List;
import java.util.Vector;

public class BoardField {

    private int x;
    private int y;
    public static final List<String> availableXs = new Vector<>();

    private static final String INDEX_OOB_MSG = "Index out of bounds for ";

    public BoardField(int tableX, int tableY){
        this.setTableXCoord(tableX);
        this.setTableYCoord(tableY);
    }

    public BoardField(char x, int y) {
        this.setBoardXCoord(x);
        this.setBoardYCoord(y);
    }

    public BoardField(String field) {
        this.setBoardXCoord(field.charAt(0));
        this.setBoardYCoord(Integer.parseInt("" + field.charAt(1)));
    }


    public void setBoardYCoord(int y) {
        if (y >= 1 && y <= Board.COLUMN_SIZE) {
            this.y = y - 1;
        } else
            throw new RuntimeException(INDEX_OOB_MSG + " y=" + y);
    }

    public void setBoardXCoord(char x) {
        x = ("" + x).toLowerCase().charAt(0);
        this.x = availableXs.indexOf(x);

        if (this.x == -1)
            throw new RuntimeException(INDEX_OOB_MSG + " x=" + x);
    }
/*
    public char getBoardXCoord() {
        return availableXs.charAt(x);
    }
*/
    public int getBoardYCoord() {
        if (y >= 0 && y <= Board.COLUMN_SIZE - 1)
            return y + 1;
        else
            throw new RuntimeException(INDEX_OOB_MSG + " y=" + y);
    }

    public void setTableXCoord(int value) {
        this.x = value;
    }

    public void setTableYCoord(int value) {
        this.y = value;
    }

    public int getTableXCoord() {
        return x;
    }

    public int getTableYCoord() {
        return y;
    }

    public boolean equals(BoardField field) {
        return (field.x == this.x)
                && (field.y == this.y);
    }

    public String toString(){
        return String.valueOf("" + /*this.getBoardXCoord() +*/ this.getBoardYCoord());
    }
}


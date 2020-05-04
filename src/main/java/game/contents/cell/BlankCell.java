package game.contents.cell;

import game.contents.Cell;

/**
 * 空白セル
 */
public class BlankCell extends Cell {
    public BlankCell(int x, int y) {
        super(x, y);
    }

    @Override
    protected void printSub() {
        System.out.print("\\");
    }
}

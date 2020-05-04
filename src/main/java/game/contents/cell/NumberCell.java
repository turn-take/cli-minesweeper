package game.contents.cell;

import game.contents.Cell;

/**
 * 数字セル
 */
public class NumberCell extends Cell {

    private final int number;

    public NumberCell(int x, int y, int number) {
        super(x, y);
        this.number = number;
    }

    @Override
    protected void printSub() {
        System.out.print(number);
    }
}

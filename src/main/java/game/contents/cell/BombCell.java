package game.contents.cell;

import game.contents.Cell;

/**
 * 爆弾セル
 */
public class BombCell extends Cell {

    public BombCell(int x, int y) {
        super(x,y);
    }

    @Override
    protected void printSub() {
        System.out.print("B");
    }
}

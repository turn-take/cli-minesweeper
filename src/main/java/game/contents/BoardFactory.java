package game.contents;

import game.contents.cell.BlankCell;
import game.contents.cell.BombCell;
import game.contents.cell.NumberCell;
import game.contents.cell.logic.CellLogic;

import java.util.Random;

public class BoardFactory {

    public static Board newBoard(int rows, int lines, int bombs) {

        Cell[][] cells = new Cell[rows][lines];

        createBombCells(rows,lines,bombs,cells);

        createNumberCells(rows, lines, cells);

        fillBlank(rows, lines, cells);

        return new Board(rows, lines, bombs ,cells);

    }

    /**
     * 爆弾セルを生成する。
     * @param rows 行数
     * @param lines 列数
     * @param bombs 爆弾の数
     * @param cells セル配列
     */
    private static void createBombCells(int rows, int lines, int bombs, Cell[][] cells) {
        for(int i = 0; i < bombs; i++) {
            while (true) {
                Random random = new Random();
                int x = random.nextInt(rows);
                int y = random.nextInt(lines);
                if (cells[x][y] == null) {
                    cells[x][y] = new BombCell(x, y);
                    break;
                }
            }
        }
    }

    /**
     * 数字セルを生成する。
     * @param rows 行数
     * @param lines 列数
     * @param cells セル配列
     */
    private static void createNumberCells(int rows, int lines, Cell[][] cells) {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < lines; y++) {
                if(cells[x][y] == null) {
                    int number = CellLogic.determineNumber(x, y, rows, lines, cells);
                    if(number != 0) {
                        cells[x][y] = new NumberCell(x, y, number);
                    }
                }
            }
        }
    }

    /**
     * 何も表示しないセルを空白で埋める
     * @param rows 行数
     * @param lines 列数
     * @param cells セル配列
     */
    private static void fillBlank(int rows, int lines, Cell[][] cells) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                if(cells[i][j] == null) {
                    cells[i][j] = new BlankCell(i,j);
                }
            }
        }
    }
}

package game.contents.cell.logic;

import game.contents.Cell;
import game.contents.cell.BlankCell;
import game.contents.cell.BombCell;
import game.contents.cell.NumberCell;

/**
 * セルのロジッククラス
 */
public class CellLogic {

    /**
     * 与えられた座標に隣接する爆弾の数を算出する。
     * @param x x座標
     * @param y y座標
     * @param cells セル配列
     * @return 隣接する爆弾の数
     */
    public static int determineNumber(int x, int y, int rows, int lines, Cell[][] cells) {

        return horizontalCount(x,y,rows,cells)
                + verticalCount(x, y, lines, cells)
                + obliqueCount(x, y, rows, lines, cells);
    }

    /**
     * 与えられた座標の水平方向にある爆弾の数を数える。
     * @param x x座標
     * @param y y座標
     * @param rows 列数
     * @param cells セル配列
     * @return 水平方向の爆弾の数
     */
    private static int horizontalCount(int x, int y, int rows, Cell[][] cells) {
        int count = 0;

        // x-1座標
        int xTmp = x - 1;
        if(xTmp > 0) {
            if(isBombCell(xTmp,y,cells)) count++;
        }

        // x+1座標
        xTmp = x + 1;
        if(xTmp < rows) {
            if(isBombCell(xTmp,y,cells)) count++;
        }

        return count;
    }

    /**
     * 与えられた座標の垂直方向にある爆弾の数を数える。
     * @param x x座標
     * @param y y座標
     * @param lines 行数
     * @param cells セル配列
     * @return 垂直方向の爆弾の数
     */
    private static int verticalCount(int x, int y, int lines, Cell[][] cells) {
        int count = 0;

        // y-1座標
        int yTmp = y - 1;
        if(yTmp > 0) {
            if(isBombCell(x,yTmp,cells)) count++;
        }

        // y+1座標
        yTmp = y + 1;
        if(yTmp < lines) {
            if (isBombCell(x,yTmp,cells)) count++;
        }

        return count;
    }

    /**
     * 与えられた座標の斜め方向にある爆弾の数を数える。
     * @param x x座標
     * @param y y座標
     * @param rows 行数
     * @param lines 列数
     * @param cells セル配列
     * @return 斜め方向の爆弾の数
     */
    private static int obliqueCount(int x, int y, int rows, int lines, Cell[][] cells) {
        int count = 0;

        // 斜め左上
        int xTmp = x - 1;
        int yTmp = y - 1;
        if(xTmp > 0 && yTmp > 0) {
            if(isBombCell(xTmp,yTmp,cells)) count++;
        }

        // 斜め右上
        xTmp = x + 1;
        yTmp = y - 1;
        if(xTmp < rows && yTmp > 0) {
            if(isBombCell(xTmp,yTmp,cells)) count++;
        }

        // 斜め左下
        xTmp = x - 1;
        yTmp = y + 1;
        if(xTmp > 0 && yTmp < lines) {
            if(isBombCell(xTmp,yTmp,cells)) count++;
        }

        // 斜め右下
        xTmp = x + 1;
        yTmp = y + 1;
        if(xTmp < rows && yTmp < lines) {
            if(isBombCell(xTmp,yTmp,cells)) count++;
        }

        return count;
    }

    /**
     * 与えられた座標が爆弾セルかを返す。
     * @param x x座標
     * @param y y座標
     * @param cells セル配列
     * @return 爆弾セルの場合はtrue
     */
    public static boolean isBombCell(int x, int y, Cell[][] cells) {
        return cells[x][y] instanceof BombCell;
    }

    /**
     * 与えられたセルが爆弾セルかを返す。
     * @param cell 対象セル
     * @return 爆弾セルの場合はtrue
     */
    public static boolean isBombCell(Cell cell) {
        return cell instanceof BombCell;
    }

    /**
     * 与えられたセルが空白セルかを返す。
     * @param cell 対象セル
     * @return 空白セルの場合はtrue
     */
    public static boolean isBlankCell(Cell cell) {
        return cell instanceof BlankCell;
    }

    /**
     * 与えられたセルが数字セルかを返す。
     * @param cell 対象セル
     * @return 数字セルの場合はtrue
     */
    public static boolean isNumberCell(Cell cell) {
        return cell instanceof NumberCell;
    }
}

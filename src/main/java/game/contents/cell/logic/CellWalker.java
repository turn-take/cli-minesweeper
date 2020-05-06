package game.contents.cell.logic;

import game.contents.Board;
import game.contents.Cell;

/**
 * セルを渡り歩く処理を行うクラス
 * インスタンスを生成するメリットはないのでstaticなユーティリティクラス
 */
public class CellWalker {

    /**
     * セルを横断して隣接する空白セルはオープンしていく。
     * @param board ゲームボード
     * @param cell 起点となるセル
     */
    public static void walKAndOpenBlankCell(Board board, Cell cell) {

        cell.setOpen(true);

        int x = cell.getX();
        int y = cell.getY();

        // 水平左側方向
        walkHorizontal(board, x, y, Operator.MINUS);
        // 水平右側方向
        walkHorizontal(board, x, y, Operator.PLUS);
        // 垂直下側方向
        walkVertical(board, x, y, Operator.MINUS);
        // 垂直上側方向
        walkVertical(board, x, y, Operator.PLUS);
        // 斜め左上方向
        walkOblique(board, x, y, Operator.MINUS, Operator.MINUS);
        // 斜め右上方向
        walkOblique(board, x, y, Operator.PLUS, Operator.MINUS);
        // 斜め左下方向
        walkOblique(board, x, y, Operator.MINUS, Operator.PLUS);
        // 斜め右下方向
        walkOblique(board, x, y, Operator.PLUS, Operator.PLUS);

    }

    /**
     * 水平方向に横断する。
     * @param board ゲームボード
     * @param x 起点となるx座標
     * @param y 起点となるy座標
     * @param ope 演算子
     */
    private static void walkHorizontal(Board board, int x, int y, Operator ope) {
        int xTmp = x + ope.getOperation();
        if(xTmp > 0 && xTmp < board.getRows()) {
            Cell target = board.getCells()[xTmp][y];
            if(CellLogic.isBlankCell(target)) {
                target.setOpen(true);
                walkHorizontal(board, xTmp, y, ope);
            } else if (CellLogic.isNumberCell(target)) {
                target.setOpen(true);
            }
        }
    }

    /**
     * 垂直方向に横断する。
     * @param board ゲームボード
     * @param x 起点となるx座標
     * @param y 起点となるy座標
     * @param ope 演算子
     */
    private static void walkVertical(Board board, int x, int y, Operator ope) {
        int yTmp = y + ope.getOperation();
        if(yTmp > 0 && yTmp < board.getLines()) {
            Cell target = board.getCells()[x][yTmp];
            if(CellLogic.isBlankCell(target)) {
                target.setOpen(true);
                walkVertical(board, x, yTmp, ope);
            } else if (CellLogic.isNumberCell(target)) {
                target.setOpen(true);
            }
        }
    }

    /**
     * 斜め方向に横断する。
     * @param board ゲームボード
     * @param x 起点となるx座標
     * @param y 起点となるy座標
     * @param xOpe x座標の指定に使う演算子
     * @param yOpe y座標の指定に使う演算子
     */
    private static void walkOblique(Board board, int x, int y, Operator xOpe, Operator yOpe) {
        int xTmp = x + xOpe.getOperation();
        int yTmp = y + yOpe.getOperation();
        if (xTmp > 0 && xTmp < board.getRows() && yTmp > 0 && yTmp < board.getLines()) {
            Cell target = board.getCells()[xTmp][yTmp];
            if (CellLogic.isBlankCell(target)) {
                target.setOpen(true);
                walkOblique(board, xTmp, yTmp, xOpe, yOpe);
            } else if (CellLogic.isNumberCell(target)) {
                target.setOpen(true);
            }
        }
    }

    /**
     * 演算子の列挙
     */
    private enum Operator {
        PLUS(+1), MINUS(-1);

        private final int operation;

        Operator(int operation) {
            this.operation = operation;
        }

        public int getOperation(){
            return operation;
        }
    }
}

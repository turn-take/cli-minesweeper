package cli;

import game.contents.Board;

/**
 * 描画インターフェースの実装クラス
 */
public class DrawerImpl implements Drawer{
    @Override
    public void draw(Board board) {
        for(int i = 0; i < board.getLines(); i++) {
            drawLineSeparator(board);
            drawRowSeparatorAndContent(board, i);
        }
        // 下部の横線
        drawLineSeparator(board);
    }

    /**
     * 横線を描画する。
     * @param board　描画対象
     */
    private void drawLineSeparator(Board board) {
        for(int i = 0; i < (board.getRows() * 4); i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }

    /**
     * 縦線と各セルの内容描画する。
     * @param board　描画対象
     * @param y y座標
     */
    private void drawRowSeparatorAndContent(Board board, int y) {
        for (int i = 0; i < board.getRows(); i++) {
            System.out.print("| ");
            board.print(i,y);
            System.out.print(" ");
        }
        System.out.println("|");
    }
}

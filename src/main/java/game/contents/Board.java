package game.contents;

import game.commands.Command;
import lombok.Getter;

import java.util.stream.Collectors;

/**
 * ゲーム盤クラス
 */
public class Board {

    // 行数
    @Getter
    private final int rows;
    // 列数
    @Getter
    private final int lines;
    // 爆弾の数
    @Getter
    private final int bombs;

    // セル
    @Getter
    private final Cell[][] cells;

    public Board(int rows, int lines, int bombs, Cell[][] cells) {
        this.rows = rows;
        this.lines = lines;
        this.bombs =  bombs;
        this.cells = cells;
    }

    /**
     * 指定された座標のセルの内容を表示する。
     * @param x x座標
     * @param y y座標
     */
    public void print(int x, int y) {
        cells[x][y].print();
    }


    /**
     * 指定された座標のセルに対してコマンドを実行する。
     * @param x x座標
     * @param y y座標
     * @param command 実行するコマンド
     */
    public void updateCell(int x, int y, Command command) {
        Cell cell = cells[x][y];
        command.execute(cell);
    }

    /**
     * 全セルに対してコマンドを実行する。
     * @param command 実行するコマンド
     */
    public void updateAllCell(Command command) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < lines; y++) {
                Cell cell = cells[x][y];
                command.execute(cell);
            }
        }
    }

}

package game;

import cli.CommandLine;
import cli.Drawer;
import cli.DrawerImpl;
import game.commands.Command;
import game.commands.OpenCommand;
import game.contents.Board;
import game.contents.BoardFactory;
import lombok.Getter;

import java.util.Objects;

/**
 * ゲームのエンジンクラス
 */
public class Engine {

    private final Drawer drawer = new DrawerImpl();

    @Getter
    private Board board;

    /**
     * 起動する。
     */
    public void boot() {
        CommandLine commandLine = new CommandLine(this);
        commandLine.open();
    }

    /**
     * ゲームの初期化をする。
     * @param rows 行数
     * @param lines 列数
     * @param bombs 爆弾の数
     */
    public void init(int rows, int lines, int bombs) {
        board = BoardFactory.newBoard(rows, lines, bombs, this);
        drawer.draw(board);
    }

    /**
     * 与えられたコマンド文字列を解析して実行する。
     * @param commandStr コマンド文字列
     * @throws IllegalArgumentException 不正なコマンドの場合
     * @return ゲームが終了している場合はtrue
     */
    public boolean parseCommand(String commandStr) throws IllegalArgumentException{
        boolean isGameOver;

        // 全部開く裏コマンド
        if(commandStr.equals("all")) {
            Command command = new OpenCommand();
            board.updateAllCell(command);
            drawer.draw(board);
            return true;
        }

        String[] commands = commandStr.split(",");
        try {
            int x = Integer.valueOf(commands[0]);
            int y = Integer.valueOf(commands[1]);
            String action = commands[2].toUpperCase();

            if(x < 0 || x > board.getRows() || y < 0 || y > board.getLines()) {
                throw new IllegalArgumentException();
            }

            Objects.requireNonNull(action);

            Command command = Command.of(action);
            isGameOver = board.updateCell(x, y, command);

            if(isGameOver) {
                board.updateAllCell(new OpenCommand());
            }

            drawer.draw(board);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | NullPointerException e) {
            drawer.draw(board);
            throw new IllegalArgumentException("Invalid command.");
        }
        return isGameOver;
    }
}

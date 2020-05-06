package game.commands;

import game.Engine;
import game.contents.Cell;

/**
 * コマンドのインターフェース
 */
public interface Command {

    /**
     * コマンドの実行
     * @param cell 対象セル
     * @return コマンドの実行で爆弾を踏んだ場合はtrue
     */
    boolean execute(Engine engine, Cell cell);

    /**
     * 与えられた文字列からコマンドを生成するstaticファクトリメソッド
     * @param action コマンド文字列
     * @return Commandオブジェクト
     * @throws IllegalArgumentException 不正なコマンドの場合
     */
    static Command of(String action) throws IllegalArgumentException{
        Command command;
        if(action.equals("O")) {
            command = new OpenCommand();
        }else if(action.equals("F")) {
            command = new FlagCommand();
        } else {
            throw new IllegalArgumentException();
        }
        return command;
    }
}

package game.commands;

import game.Engine;
import game.contents.Cell;

/**
 * フラグのコマンド
 */
public class FlagCommand implements Command{

    /**
     * 対象のセルのフラグの状態を反転する。
     * @param cell 対象セル
     * @return 常にfalse
     */
    @Override
    public boolean execute(Engine engine, Cell cell) {
        // セルが開いていない場合のみ
        if(!cell.isOpen()) cell.reverseFlag();
        return false;
    }
}

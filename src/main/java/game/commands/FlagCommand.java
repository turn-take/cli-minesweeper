package game.commands;

import game.contents.Cell;

/**
 * フラグのコマンド
 */
public class FlagCommand implements Command{

    /**
     * 対象のセルのフラグの状態を反転する。
     * @param cell 対象セル
     */
    @Override
    public void execute(Cell cell) {
        // セルが開いていない場合のみ
        if(!cell.isOpen()) cell.reverseFlag();
    }
}

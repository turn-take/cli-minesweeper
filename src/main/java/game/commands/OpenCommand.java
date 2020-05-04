package game.commands;

import game.contents.Cell;

/**
 * セルを開くコマンド
 */
public class OpenCommand implements Command{

    /**
     * 対象セルを開く
     * @param cell 対象セル
     */
    @Override
    public void execute(Cell cell) {
        // セルが開いていない場合のみ
        if(!cell.isOpen()) cell.setOpen(true);
    }
}

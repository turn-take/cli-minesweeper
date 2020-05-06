package game.commands;

import game.Engine;
import game.contents.Cell;
import game.contents.cell.logic.CellLogic;
import game.contents.cell.logic.CellWalker;

/**
 * セルを開くコマンド
 */
public class OpenCommand implements Command{

    /**
     * 対象セルを開く
     * @param cell 対象セル
     * @return 爆弾セルを開いた場合はtrue
     */
    @Override
    public boolean execute(Engine engine, Cell cell) {

        // セルが開いていない場合のみ
        if(!cell.isOpen()) {
            cell.setOpen(true);
            // 爆弾セルならゲームオーバー
            if(CellLogic.isBombCell(cell)) {
                return true;
            } else if(CellLogic.isBlankCell(cell)) {
                CellWalker.walKAndOpenBlankCell(engine.getBoard(), cell);
            }
        }
        return false;
    }
}

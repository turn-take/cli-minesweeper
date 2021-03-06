package game.contents;

import lombok.Getter;
import lombok.Setter;

/**
 * セルの抽象クラス
 */
public abstract class Cell {

    // x座標
    @Getter
    private final int x;
    // y座標
    @Getter
    private final int y;

    // フラグが立っているかどうか
    @Getter
    @Setter
    private boolean flag = false;

    // 開かれたセルかどうか
    @Getter
    @Setter
    private boolean open = false;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * セルの内容を表示する。
     * フラグが立っているセルの場合は「F」を表示する。
     */
    public void print() {
        if(!open) {
            if(flag) {
                System.out.print("F");
            } else {
                System.out.print(" ");
            }
        } else {
            printSub();
        }
    }

    /**
     * セルの内容を表示する。
     * 継承先で定義する用。
     */
    protected abstract void printSub();

    /**
     * フラグを反転させる
     */
    public void reverseFlag() {
        flag = !flag;
    }

}

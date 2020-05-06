package cli;

import game.Engine;

import java.util.Scanner;

public class CommandLine {

    private final Engine engine;

    public CommandLine(Engine engine) {
        this.engine = engine;
    }

    /**
     * コマンドラインをオープンし、文字列を受け付ける。
     */
    public void open() {

        // TODO ゲームの開始時に行×列、爆弾の数を動的に変えられるようにする。
        engine.init(10,10,15);

        System.out.print(">");

        try(Scanner scan = new Scanner(System.in)){
            while(scan.hasNext()) {
                String commandStr = scan.nextLine();
                if(commandStr.equals("quit")) break;

                boolean result = false;
                try {
                    result = engine.parseCommand(commandStr);
                    if (result) break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                } finally {
                    if(!result) System.out.print(">");
                }
            }
        }
    }
}

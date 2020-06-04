package hk.edu.polyu.comp.comp2021.jungle.view;
import hk.edu.polyu.comp.comp2021.jungle.model.Player;

/**
 * initialize the view show to player
 */
// print the board
public class JungleView {


    /**
     * @param message show message to palyer
     */
    public static void messageWithNextLine(Object message) {
        System.out.println(message);
    }

    /**
     * @param message show message to palyer
     */
    public static void message(Object message) {
        System.out.print(message);
    }

    /**
     * @param player1 player one info
     * @param player2 palyer two info
     * @param jungleBoard current jungle board
     */
    public static void PrintBoard(Player player1, Player player2, char[][] jungleBoard) {

        int z = 1;
        JungleView.messageWithNextLine("Player one : " + player1.GetName());

        for (int i = 0; i < 9; i++) {

            JungleView.message(z++ + "|");
            for (int j = 0; j < 7; j++) {
                String x = "  ";
                if (jungleBoard[i][j] == '河') x = "\u001B[34m" + jungleBoard[i][j] + "\u001B[0m";
                if (player1.isYourOwnChess(j, i)) x = "\u001B[31m" + jungleBoard[i][j] + "\u001B[0m";
                if (player2.isYourOwnChess(j, i)) x = "\u001B[30m" + jungleBoard[i][j] + "\u001B[0m";
                if (jungleBoard[i][j] == '阱' || jungleBoard[i][j] == '穴') x = jungleBoard[i][j] + "\u001B[0m";

                JungleView.message(x);
                JungleView.message("|");
            }
            JungleView.message("\n");
        }
        JungleView.messageWithNextLine("　一 一 一 一 一 一 一");
        JungleView.message("  ");
        for (int i = 0; i < 7; i++) {
            char x = (char) (65 + i);
            JungleView.message(x + "　");
        }
        JungleView.message("\n");
        JungleView.messageWithNextLine("Player two : " + player2.GetName());

    }
}

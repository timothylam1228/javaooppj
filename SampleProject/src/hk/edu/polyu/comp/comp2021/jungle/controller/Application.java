package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.view.JungleView;


/**
 * This class handle the launch of the game
 */
public class Application {

    /**
     * @param args main function when user start the program
     */
    public static void main(String[] args) {

        JungleGame game = new JungleGame();
        String input;

        JungleView.messageWithNextLine("The Jungle Game");
        JungleView.message("start or load:");

        do {
            try {
                input = GetInput.Input().toUpperCase();
            } catch (Exception e) {
                JungleView.messageWithNextLine("The input must be string.");
                input = "";
            }
        } while (InputChecker.startOrLoad(input));
        //loop until user input start or load


        int playerCon = 1;

        // load situation
        if (input.equals("LOAD")) {
            JungleView.messageWithNextLine("Loading files...");
            playerCon = game.Load();
            if (playerCon == -1) {
                System.out.println("Start game with default setting");
                input = "START";
            } else game.boardPrint();

        }
        // start playing the game
        if (input.equals("START")) {
            game.getName();
            game.ChessInsert();
            game.boardPrint();
            playerCon = 1;

        }

        //loop the turn
        while (true) {

            try {
                if (playerCon == 1) {
                    JungleView.message(game.getPlayer1Name() + " turn, please input [move A1 A2] to move/ [save] to save/ [load] to load:");
                } else {
                    JungleView.message(game.getPlayer2Name() + " turn, please input [move A1 A2] to move/ [save] to save/ [load] to load:");
                }

                input = GetInput.InputWithNextLine().toUpperCase();
                String[] splitter = input.split("\\s+");

                // the save case
                if (splitter[0].equals("SAVE")) {
                    System.out.println("Saving files...");
                    game.Save(playerCon);
                    game.boardPrint();
                    continue;
                }

                // the load case
                if (splitter[0].equals("LOAD")) {
                    int temp = playerCon;
                    JungleView.messageWithNextLine("Loading files...");
                    playerCon = game.Load();
                    if (playerCon == -1) {
                        playerCon = temp;
                        continue;
                    }
                    game.boardPrint();
                }

                // move
                if (!splitter[0].equals("MOVE")) {
                    System.out.println("please input [move A1 A2] to move:");
                    continue;
                }

                char[] originalChess = splitter[1].toCharArray();
                originalChess[0] = splitter[1].charAt(0);
                int x = originalChess[0] - 65;
                int y = originalChess[1] - 49;
                if (x < 0 || x > 7 || y < 0 || y > 9) throw new Exception();

                char[] targetLocation = splitter[2].toCharArray();
                targetLocation[0] = splitter[2].charAt(0);

                int x1 = targetLocation[0] - 65;
                int y1 = targetLocation[1] - 49;
                if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 9) throw new Exception();

                if (playerCon == 1) {
                    if (game.UserMove(x, y, x1, y1, playerCon))
                        playerCon = 2;
                } else {
                    if (game.UserMove(x, y, x1, y1, playerCon))
                        playerCon = 1;
                }

                game.boardPrint();
            } catch (Exception e) {
                JungleView.messageWithNextLine("Input does not in range A0 to G9");
            }
        }


    }
}

package hk.edu.polyu.comp.comp2021.jungle.controller;


import hk.edu.polyu.comp.comp2021.jungle.model.*;
import hk.edu.polyu.comp.comp2021.jungle.view.JungleView;


/**
 *
 */
class JungleGame {
    private GameBoard jungleBoard;
    private Player x = new Player();
    private Player y = new Player();


    /**
     * Store the character into the jungleBoard Array
     */
    JungleGame() {

        jungleBoard = new GameBoard();
        char trap = Traps.getTrapsChar(), den = Dens.getDenChar();

        jungleBoard.Insert(trap, 2, 0);
        jungleBoard.Insert(trap, 4, 0);
        jungleBoard.Insert(trap, 3, 1);
        jungleBoard.Insert(den, 3, 0);
        x.setTrapsCoordinate(0, 2, 0);
        x.setTrapsCoordinate(1, 4, 0);
        x.setTrapsCoordinate(2, 3, 1);
        x.setDenCoordinate(3, 0);

        jungleBoard.Insert(trap, 2, 8);
        jungleBoard.Insert(trap, 4, 8);
        jungleBoard.Insert(trap, 3, 7);
        jungleBoard.Insert(den, 3, 8);
        y.setTrapsCoordinate(0, 2, 8);
        y.setTrapsCoordinate(1, 4, 8);
        y.setTrapsCoordinate(2, 3, 7);
        y.setDenCoordinate(3, 8);
    }

    /**
     * Let user input their name
     */
    //Get the name of Players
    void getName() {
        JungleView.message("Please input player 1 name:");
        x.SetName(GetInput.Input());
        JungleView.message("Please input player 2 name:");
        y.SetName(GetInput.Input());
    }

    /**
     * @return palyer one name
     */
    // The function print the jungleBoard and user name
    String getPlayer1Name() {
        return x.GetName();
    }

    /**
     * @return player two name
     */
    String getPlayer2Name() {
        return y.GetName();
    }

    /**
     * Print the game board
     */
    void boardPrint() {
        JungleView.PrintBoard(x, y, jungleBoard.getJungleBoard());
    }

    /**
     * inset the chess to the board
     */
    //Create the chess in first time
    void ChessInsert() {

        x.ChessCreator(0, 0, 6);
        jungleBoard.Insert(x.GetChess(6), x.GetX(6), x.GetY(6));

        x.ChessCreator(6, 0, 5);
        jungleBoard.Insert(x.GetChess(5), x.GetX(5), x.GetY(5));

        x.ChessCreator(1, 1, 2);
        jungleBoard.Insert(x.GetChess(2), x.GetX(2), x.GetY(2));

        x.ChessCreator(5, 1, 1);
        jungleBoard.Insert(x.GetChess(1), x.GetX(1), x.GetY(1));

        x.ChessCreator(0, 2, 0);
        jungleBoard.Insert(x.GetChess(0), x.GetX(0), x.GetY(0));

        x.ChessCreator(2, 2, 4);
        jungleBoard.Insert(x.GetChess(4), x.GetX(4), x.GetY(4));

        x.ChessCreator(4, 2, 3);
        jungleBoard.Insert(x.GetChess(3), x.GetX(3), x.GetY(3));

        x.ChessCreator(6, 2, 7);
        jungleBoard.Insert(x.GetChess(7), x.GetX(7), x.GetY(7));
        ////////////////////////////////////
        ////////////////////////////////////
        ///////////////////////////////
        y.ChessCreator(0, 8, 5);
        jungleBoard.Insert(x.GetChess(5), y.GetX(5), y.GetY(5));

        y.ChessCreator(6, 8, 6);
        jungleBoard.Insert(x.GetChess(6), y.GetX(6), y.GetY(6));

        y.ChessCreator(1, 7, 1);
        jungleBoard.Insert(x.GetChess(1), y.GetX(1), y.GetY(1));

        y.ChessCreator(5, 7, 2);
        jungleBoard.Insert(x.GetChess(2), y.GetX(2), y.GetY(2));

        y.ChessCreator(0, 6, 7);
        jungleBoard.Insert(x.GetChess(7), y.GetX(7), y.GetY(7));

        y.ChessCreator(2, 6, 3);
        jungleBoard.Insert(x.GetChess(3), y.GetX(3), y.GetY(3));

        y.ChessCreator(4, 6, 4);
        jungleBoard.Insert(x.GetChess(4), y.GetX(4), y.GetY(4));

        y.ChessCreator(6, 6, 0);
        jungleBoard.Insert(x.GetChess(0), y.GetX(0), y.GetY(0));
    }

    //Build the board with no chess


    /**
     * @param OriX Original X corrdinate
     * @param OriY Original Y corrdinate
     * @param targetX Traget X corrdinate
     * @param targetY Traget Y corrdinate
     * @param player palyer to move
     * @return false if user move wrong
     */
    boolean UserMove(int OriX, int OriY, int targetX, int targetY, int player) {

        // the fail case of no progress
        if (targetX == OriX && targetY == OriY) {
            System.out.println("You need to move");
            return false;
        }

        // the fail case of enter the den
        if (player == 1 && x.isDen(targetX, targetY) || player == 2 && y.isDen(targetX, targetY)) {
            System.out.println("Cant step on own den");
            return false;
        }

        /////////////////////////////////
        // Only rat can get into river //
        /////////////////////////////////
        if (jungleBoard.isRiver(targetX, targetY)) {
            if (jungleBoard.getChessChar(OriX, OriY) != '鼠') {
                JungleView.messageWithNextLine("You cant get into river");
                return false;
            }
        }

        boolean tigerOrLion = false;
        // tiger and lion can jump over the river
        if (jungleBoard.getChessChar(OriX, OriY) == '獅' || jungleBoard.getChessChar(OriX, OriY) == '虎') {
            if (jungleBoard.isRiverSide(OriX, OriY) && jungleBoard.isRiverSide(targetX, targetY)) {
                tigerOrLion = true;
                if (targetX == OriX && Math.abs(targetY - OriY) == 4) {
                    if (jungleBoard.getChessChar(OriX, 3) == '鼠' || jungleBoard.getChessChar(OriX, 4) == '鼠' || jungleBoard.getChessChar(OriX, 5) == '鼠') {
                        System.out.println("Cant Cross , have mice inside the river");
                        return false;
                    }
                }
                if (targetY == OriY && Math.abs(targetX - OriX) == 3) {
                    if ((OriX == 0 && targetX == 3) || (OriX == 3 && targetX == 0)) {
                        if (jungleBoard.getChessChar(1, OriY) == '鼠' || jungleBoard.getChessChar(2, OriY) == '鼠') {
                            System.out.println("Cant Cross , have mice inside the river");
                            return false;
                        }
                    }
                    if ((OriX == 3 && targetX == 6) || (OriX == 6 && targetX == 3)) {
                        if (jungleBoard.getChessChar(4, OriY) == '鼠' || jungleBoard.getChessChar(5, OriY) == '鼠') {
                            System.out.println("Cant Cross , have mice inside the river");
                            return false;
                        }
                    }

                }
            }
        }

        // Not allow the chess jump more than one board without tiger and lion
        if ((Math.abs(targetX - OriX) + Math.abs(targetY - OriY) > 1) && !tigerOrLion) {
            System.out.println("Invalid input, you can only move vertically or horizontally with one space");
            return false;
        }


        if (player == 1) {
            // the case that the choosing point is not the player chess
            if (!x.isYourOwnChess(OriX, OriY)) {
                JungleView.messageWithNextLine("It is not your chess/ There is no chess");
                return false;
            }

            // the case that the choosing point and the target point is same player's chess
            if (x.isYourOwnChess(OriX, OriY) && x.isYourOwnChess(targetX, targetY)) {
                JungleView.messageWithNextLine("Same player chess, not a valid move");
                return false;
            }

            // the case that mouse can't eat the chess which is on land
            if (jungleBoard.getChessChar(OriX, OriY) == '鼠' && jungleBoard.isRiver(OriX, OriY)) {
                if (!jungleBoard.isRiver(targetX, targetY) && y.isYourOwnChess(targetX, targetY)) {
                    System.out.println("You can't eat enemy on land");
                    return false;
                }
            }

            //testing the enemy is exist or not in target point and update the coordinate
            if (!(testEnemy(OriX, OriY, targetX, targetY, player))) {
                return false;
            } else y.chessCoordinateUpdate(targetX, targetY, -1, -1);
            x.chessCoordinateUpdate(OriX, OriY, targetX, targetY);

        }

        // same as the situation of player1
        if (player == 2) {

            if (!y.isYourOwnChess(OriX, OriY)) {
                JungleView.messageWithNextLine("It is not your chess/ There is no chess");
                return false;
            }
            if (y.isYourOwnChess(OriX, OriY) && y.isYourOwnChess(targetX, targetY)) {
                JungleView.messageWithNextLine("Same player chess, not a valid move");
                return false;
            }
            if (jungleBoard.getChessChar(OriX, OriY) == '鼠' && jungleBoard.isRiver(OriX, OriY)) {
                if (!jungleBoard.isRiver(targetX, targetY) && x.isYourOwnChess(targetX, targetY)) {
                    System.out.println("You can't eat enemy on land");
                    return false;
                }
            }
            if (!(testEnemy(OriX, OriY, targetX, targetY, player))) {
                return false;
            } else x.chessCoordinateUpdate(targetX, targetY, -1, -1);
            y.chessCoordinateUpdate(OriX, OriY, targetX, targetY);
        }

        // upload the gameboard
        jungleBoard.Insert(jungleBoard.getChessChar(OriX, OriY), targetX, targetY);
        jungleBoard.Insert(' ', OriX, OriY);


        if (jungleBoard.isRiver(OriX, OriY)) {
            jungleBoard.Insert('河', OriX, OriY);
        }
        if (x.isTraps(OriX, OriY) || y.isTraps(OriX, OriY)) {
            jungleBoard.Insert('阱', OriX, OriY);
        }


        JungleView.messageWithNextLine("Moved");
        if ((player == 1 && y.isDen(targetX, targetY)) || (player == 2 && x.isDen(targetX, targetY))) {
            System.out.println("Steped on 穴");
            if (player == 1) {
                JungleView.messageWithNextLine("player 1 wins");
            } else JungleView.messageWithNextLine("player 2 wins");

            Win();

        }

        return true;
    }

    /////////////////////////////////
    //     Step on enemy chess     //
    /////////////////////////////////
    private boolean testEnemy(int OriX, int OriY, int targetX, int targetY, int player) {
        if ((x.isYourOwnChess(OriX, OriY) && y.isYourOwnChess(targetX, targetY)) || (y.isYourOwnChess(OriX, OriY) && x.isYourOwnChess(targetX, targetY)))
            return Fight(OriX, OriY, targetX, targetY, player);
        return true;
    }

    // Compare the rank and prepare to eat the chess
    private boolean Fight(int OriX, int OriY, int newX, int newY, int player) {
        Chess Chess1 = new Chess(OriX, OriY, jungleBoard.getChessChar(OriX, OriY));
        Chess Chess2 = new Chess(newX, newY, jungleBoard.getChessChar(newX, newY));
        System.out.println("Chess one is: " + Chess1.GetChess());
        System.out.println("Chess two is: " + Chess2.GetChess());
        boolean z = false;
        if (player == 1) {
            z = x.isTraps(newX, newY);
        }
        if (player == 2) {
            z = y.isTraps(newX, newY);
        }
        if (!z) {
            if (Chess1.GetRank() == 0 && (Chess2.GetRank() == 7)) {
                System.out.println(Chess1.GetChess() + ">" + Chess2.GetChess());
                return true;
            }
            if (Chess1.GetRank() == 7 && (Chess2.GetRank() == 0)) {
                System.out.println(Chess1.GetChess() + "<" + Chess2.GetChess());
                return false;
            }
            if (Chess1.GetRank() >= Chess2.GetRank()) {
                System.out.println(Chess1.GetChess() + ">" + Chess2.GetChess());

                return true;
            } else {
                System.out.println(Chess1.GetChess() + "<" + Chess2.GetChess());

                return false;
            }
        } else {
            System.out.println("Trap kill");
            return true;
        }

    }

    // the case of win
    private void Win() {
        System.out.println("FINISHHHHHHHHHHHHHHHHHHHHH");
        System.exit(0);

    }

    /**
     * @param playerTurn if user inputed save then run save function
     */
    void Save(int playerTurn) {
        SaveFile.main(x, y, playerTurn, x.GetName(), y.GetName());
    }

    /**
     * @return loaded file
     */
    int Load() {
        try {
            LoadFile loadFile = new LoadFile();
            x.SetName(loadFile.getPlayer1Name());
            y.SetName(loadFile.getPlayer2Name());
             Chess[] chessSet = loadFile.getChessSet();
            int i = 0;
            for (int j = 0; j < 8; j++) {

                x.ChessCreator(chessSet[i].GetX(), chessSet[i].GetY(), chessSet[i].GetRank());
                jungleBoard.Insert(x.GetChess(chessSet[i].GetRank()), chessSet[i].GetX(), chessSet[i].GetY());
                i++;
                y.ChessCreator(chessSet[i].GetX(), chessSet[i].GetY(), chessSet[i].GetRank());
                jungleBoard.Insert(y.GetChess(chessSet[i].GetRank()), chessSet[i].GetX(), chessSet[i].GetY());
                i++;
            }
            return loadFile.getTurn();

        } catch (Exception e) {
            System.out.println("File doesn't exist");
        }
        return -1;
    }
}
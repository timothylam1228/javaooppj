package hk.edu.polyu.comp.comp2021.jungle.controller;



import hk.edu.polyu.comp.comp2021.jungle.model.Chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


/**
 * Class to run Load function
 */
class LoadFile {

    /**
     * have 16 chess need to laod
     */
    public static final int CHESSNUMBER = 16;
    private String player1Name, player2Name;
    private int turn;
    private Chess[] chess = new Chess[CHESSNUMBER];

    /**
     * @return chess
     */
    Chess[] getChessSet() {
        return chess;
    }

    /**
     * @return the player name to save
     */
    String getPlayer1Name() {
        return player1Name;
    }

    /**
     * @return the turn which player is going to play next
     */
    int getTurn() {
        return turn;
    }

    /**
     * @return player two name
     */
    String getPlayer2Name() {
        return player2Name;
    }

    /**
     * @throws Exception main load function
     */
    LoadFile() throws Exception {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter File path (Enter 'output.txt' to store in the same file)");
        BufferedReader sc = new BufferedReader(new FileReader(x.nextLine()));

        int i = 0;
        //char JBline = sc.nextLine().trim().split("");
        for (int j = 0; j < 8; j++) {
            String JBline = sc.readLine();
            chess[i] = new Chess(Character.getNumericValue(JBline.charAt(0)), Character.getNumericValue(JBline.charAt(1)));
            chess[i++].SetRank(j);
            chess[i] = new Chess(Character.getNumericValue(JBline.charAt(2)), Character.getNumericValue(JBline.charAt(3)));
            chess[i++].SetRank(j);
        }

        this.turn = Integer.parseInt(sc.readLine());
        this.player1Name = sc.readLine();
        this.player2Name = sc.readLine();
        System.out.println("File Loaded");

    }

}







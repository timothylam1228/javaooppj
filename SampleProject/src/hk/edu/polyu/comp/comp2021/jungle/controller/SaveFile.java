package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Save File
 */
class SaveFile {
    /**
     * @param player1 palyer one chess
     * @param player2 player two chess
     * @param playerTurn which palyer turn next
     * @param playerName1 palyer one name
     * @param playerName2 player two name
     */
    static void main(Player player1, Player player2, int playerTurn, String playerName1, String playerName2) {
        String Pathway;
        System.out.println("Enter File path (Enter 'output.txt' to store in the same file)");
        Scanner sc = new Scanner(System.in);
        Pathway = sc.nextLine();
        System.out.println("Saving Files...)");
        try (
                PrintStream output = new PrintStream(new File(Pathway));) {

            for (int i = 0; i < 8; i++) {
                StringBuilder s = new StringBuilder();

                s.append("" + player1.GetX(i) + player1.GetY(i) + player2.GetX(i) + player2.GetY(i));

                output.println(s);
            }

            output.println(playerTurn);
            output.println(playerName1);
            output.println(playerName2);
            System.out.println("Files Saved Successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
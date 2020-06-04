package hk.edu.polyu.comp.comp2021.jungle.controller;

import java.util.Scanner;

/**
 *
 */
class GetInput {

    /**
     * @return user input
     */
    static String Input(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    /**
     * @return user String input
     */
    static String InputWithNextLine(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}

//Static function for getting input

package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.view.JungleView;

/**
 * Check user inputed what
 */
class InputChecker {

    /**
     * @param string check user inputed check or laod
     * @return false if user input correct
     */
    static boolean startOrLoad(String string) {
        if (string.equals("START") || string.equals("LOAD")) return false;
        else {
            JungleView.message("Please input start or load");
            return true;
        }
    }
}// checking the input

//standart Intellij Idea package name
package com.company;

//import user input class
import java.util.Scanner;

//difficulty of the mental calculating training class declaration
public class DifficultySet {
    //easy, medium or hard level of difficulty
    //declaration variable that keeps difficulty level by number
    public static int difficultyLevel;

    public static void difficultyLevelSet() {
        //user input for difficulty choice
        //creating object that responsible for user input
        Scanner difEnter = new Scanner(System.in);
        //user line of symbols
        String userDifficulty = difEnter.nextLine();

        //changing variable by user input
        //difficulty switching
        switch(userDifficulty)
        {
            case "1":
                difficultyLevel = 1;
                break;
            case "2":
                difficultyLevel = 2;
                break;
            case "3":
                difficultyLevel = 3;
                break;
            default:
                System.out.println("Please type \"1\", \"2\", or \"3\"");
                difficultyLevelSet();
        }
    }
}

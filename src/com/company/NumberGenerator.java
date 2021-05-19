//standart Intellij Idea package name
package com.company;

//import random number generating class
import java.util.Random;
//import user input class
import java.util.Scanner;

//math class declaration
public class NumberGenerator {
    //numbers variables declaration
    public static int firstNumber;
    public static int secondNumber;
    //plus, minus, multiply or divide variable declaration
    public static String mathOperator;

    //result of math expression variable declaration
    public static int result;
    //creating of random expressions object
    private static Random random = new Random();;

    //generating first and second numbers that are depending from difficulty level
    public static void generateNumbers() {
        //difficulty level
        if(DifficultySet.difficultyLevel == 1) {
            //generating numbers from 2 to 9
            firstNumber = 2 + random.nextInt(10 - 2);
            secondNumber = 2 + random.nextInt(10 - 2);
        }
        //difficulty level
        else if(DifficultySet.difficultyLevel == 2) {
            //generating numbers from 2 to 99
            firstNumber = 2 + random.nextInt(100 - 2);
            secondNumber = 2 + random.nextInt(100 - 2);
        }
        //difficulty level
        else if(DifficultySet.difficultyLevel == 3) {
            //generating numbers from 2 to 999
            firstNumber = 2 + random.nextInt(1000 - 2);
            secondNumber = 2 + random.nextInt(10000 - 2);
        }

    }

    //generating plus, minus, multiply or divide
    public static void generateMathOperator() {
        //generating random number
        int genOperator = random.nextInt(4);
        //comparing random number with plus, minus, multiply or divide
        if (genOperator == 0) {
            mathOperator = "+";
            result = firstNumber + secondNumber;
        }
        else if (genOperator == 1) {
            mathOperator = "-";
            //condition when first number bigger than second number
            if (firstNumber >= secondNumber) {
                result = firstNumber - secondNumber;
            }
            else {
                generateNumbers();
                generateMathOperator();
            }
        }
        else if (genOperator == 2) {
            mathOperator = "*";
            result = firstNumber * secondNumber;
        }
        else if (genOperator == 3) {
            mathOperator = "/";
            //condition when numbers do not equals zero and gives zero by dividing integrally
            if (firstNumber != 0 && secondNumber != 0 && firstNumber % secondNumber == 0) {
                result = firstNumber / secondNumber;
            }
            else {
                generateNumbers();
                generateMathOperator();
            }
        }
    }

    //checking that user input is integer
    private static boolean checkString(String string) {
        //creating exception if user input is not integer
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //listening user math expression result guess
    public static void guess() {
        System.out.println(firstNumber + " " + mathOperator + " " + secondNumber);

        //creating object that responsible for user input
        Scanner guessEnter = new Scanner(System.in);
        //user line of symbols
        String userAnswer = guessEnter.nextLine();

        //declaration variable that keeps user input line converted to integer
        int intAnswer;

        //final operation
        //checking that user enters a number
        //compare math operation result with user guess
        if (checkString(userAnswer)) {
            //convert (parse) string to integer
            intAnswer = Integer.parseInt(userAnswer);
            //compare math operation result with user guess
            if (intAnswer != result) {
                System.out.println("wrong");
                guess();
            }
            else {
                System.out.println("right");
                generateNumbers();
                generateMathOperator();
                guess();
            }
        }
        else {
            System.out.println("wrong");
            guess();
        }
    }
}



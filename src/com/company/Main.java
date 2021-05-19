//standart Intellij Idea package name
package com.company;

//the Main class
public class Main {
    //the main method
    //the program starts with this method
    public static void main(String[] args) {
        //the welcome statement
        System.out.println("Welcome! This is a mental calculating trainer program");
        System.out.println("Please choose the difficulty level");
        System.out.println("Type:");
        System.out.println("\"1\" - easy (numbers from 2 to 9)");
        System.out.println("\"2\" - medium (numbers from 2 to 99)");
        System.out.println("\"3\" - hard (numbers from 2 to 999)");

        //choosing easy, medium or hard level of difficulty
        DifficultySet.difficultyLevelSet();

        //generating first and second numbers
        NumberGenerator.generateNumbers();
        //generating plus, minus, multiply or divide operator
        NumberGenerator.generateMathOperator();
        //listening user guess input
        NumberGenerator.guess();
    }
}

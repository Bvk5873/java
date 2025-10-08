/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp;

import java.util.Scanner;

/**
 *
 * @author bollu
 */
public class Quizapp {

    /**
     * @param args the command line arguments
     */

class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class Quiz  {
    
    protected Question[] questions;
    protected int score;

    /**
     *
     */
    public Quiz() {
        score = 0;
        initializeQuestions();
    }
    
    protected void initializeQuestions() {
        // Add your questions here
        // Example:
        questions = new Question[]{
            new Question("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Rome", "D. Berlin"}, 1),
            new Question("What is 2 + 2?", new String[]{"A. 3", "B. 4", "C. 5", "D. 6"}, 1),
        };
    }
    
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            int userChoice = userAnswer.charAt(0) - 'A';

            if (userChoice == question.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score is: " + score + "/" + questions.length);
    }
}

class CustomQuiz extends Quiz {
    @Override
    protected void initializeQuestions() {
        // Customize your questions here
        // Example:
        questions = new Question[]{
            new Question("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Rome", "D. Berlin"}, 1),
            new Question("Custom Question 2?", new String[]{"A. Option A", "B. Option B", "C. Option C", "D. Option D"}, 2),
        };
    }
}

    
}

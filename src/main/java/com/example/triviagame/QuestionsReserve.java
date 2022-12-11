package com.example.triviagame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class QuestionsReserve {
    private final String FILE_NAME = "trivia.txt";
    private final int MAX_ANSWERS = 4;

    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    private int currAnswerIndex = 0;
    private int currQuestionIndex = 0;
    private int randInd;
    private int totalQuestions;

    public void resetQuestions(){
        currAnswerIndex = 0;
        currQuestionIndex = 0;
    }

    public int questionsLeft(){
        currQuestionIndex++;
        return totalQuestions-currQuestionIndex;
    }

    public String getQuestion(){
        return questions.get(currQuestionIndex);
    }

    public ArrayList<String> getAnswers(){
        ArrayList<String> orderedAnswers = new ArrayList<String>();
        for (int i=0;i<MAX_ANSWERS;i++) {
            orderedAnswers.add(answers.get(currAnswerIndex));
            currAnswerIndex++;
        }
        return orderedAnswers;
    }

    public void parseQuestions(){
        try {
            Scanner input = new Scanner(new File(FILE_NAME));
            int counter = 0;
            while (input.hasNextLine()) {
                if (counter % 5 == 0) {
                    questions.add(input.nextLine());
                    totalQuestions++;
                }
                else
                    answers.add(input.nextLine());
                counter++;
            }
            input.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File '"+ FILE_NAME + "' was not found.\nPlease make sure it exist outside of /src directory.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }


}

package com.example.triviagame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionsReserve {
    private final String FILE_NAME = "trivia.txt";
    private final int MAX_ANSWERS = 4;

    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    private ArrayList<Integer> randomizedInd = new ArrayList<Integer>();
    private int currAnswerIndex = 0;
    private int currQuestionIndex = 0;
    private int totalQuestions;
    private int questionsLeft;

    public void resetQuestions(){
        currAnswerIndex = 0;
        currQuestionIndex = 0;
        questionsLeft = totalQuestions;
    }

    public String getQuestion(){ //using randomizedInd array to get a random index
        int randInd = totalQuestions-questionsLeft;
        currQuestionIndex = randomizedInd.get(randInd) / MAX_ANSWERS;
        currAnswerIndex = randomizedInd.get(randInd);
        questionsLeft--;
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
                    randomizedInd.add(answers.size()); //collecting the indexes of each block of answers start
                }
                else
                    answers.add(input.nextLine());
                counter++;
            }
            input.close();
            questionsLeft = totalQuestions;
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File '"+ FILE_NAME + "' was not found.\nPlease make sure it exist outside of /src directory.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void randomizeQuestion(){
        Collections.shuffle(randomizedInd);
    }


}

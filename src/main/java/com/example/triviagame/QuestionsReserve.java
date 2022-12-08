package com.example.triviagame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuestionsReserve {

    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    private final String FILE_NAME = "trivia.txt";
    private final int MAX_ANSWERS = 4;
    private int questionNum = 0;
    private int questionsIndex = 0;

    public int questionsLeft(){
        return questionsIndex;
    }


    public String getQuestion(){
            questionsIndex--;
            return questions.get(questionNum/MAX_ANSWERS);
    }

    public ArrayList<String> getAnswers(){
        ArrayList<String> orderedAnswers = new ArrayList<String>();
        orderedAnswers.add(answers.get(questionNum++));
        orderedAnswers.add(answers.get(questionNum++));
        orderedAnswers.add(answers.get(questionNum++));
        orderedAnswers.add(answers.get(questionNum++));
        return orderedAnswers;
    }

    public ArrayList<String> getQuestions(){
        return questions;
    }

    public ArrayList<String> getAnswers2(){
        return answers;
    }

    public void parseQuestions(){
        try { // need to do for each 5th line
            //probably send the answers to question class
            Scanner input = new Scanner(new File(FILE_NAME));
            int counter = 0;
            while (input.hasNextLine()) {
                if (counter % 5 == 0) {
                    questions.add(input.nextLine());
                    questionsIndex++;
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

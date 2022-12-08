package com.example.triviagame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Questions {

    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    private final String FILE_NAME = "trivia.txt";

    public void parseQuestions(){
        try { // need to do for each 5th line
            //probably send the answers to question class
            Scanner input = new Scanner(new File(FILE_NAME));
            int counter = 0;
            while (input.hasNext()) {
                if (counter % 5 == 0) {
                    questions.add(input.next());

                    //     answers.clear();
                }
                else
                    answers.add(input.next());
                counter++;
            }
            input.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File '"+ FILE_NAME + "' was not found.\nPlease make sure it exist outside of /src directory.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public String generateWord(){

        Random rand = new Random();
        String word = questions.get(rand.nextInt(questions.size()));
        return word;
    }

}

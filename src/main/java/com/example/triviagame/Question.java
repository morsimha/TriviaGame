package com.example.triviagame;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question;
    private ArrayList<String> shuffeldAnswers = new ArrayList<String>();
    private int questionCounter;
    private int score;
    private String correctAns;
    private boolean correctGuess;

    public void setQuestion(String currQuestion){
        question = currQuestion;
    }

    public void setShuffeldAnswers(ArrayList<String> answers){
        correctAns = answers.get(0);
        Collections.shuffle(answers);
        shuffeldAnswers = answers;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(int ind){
        return shuffeldAnswers.get(ind);
    }

    public String getCorrectAnswer(){
        return correctAns;
    }

    public int getScore(){
        return score;
    }

    public int getNextSession(){
        return questionCounter;
    }

//    public void nextQuestion(){
//        return questionCounter;
//    }

    public void updateScore(boolean right){
        if (right)
            score+=10;
        else
            score-=5;
    }

    public String greetMessage(boolean right){
        if (right)
            return "Correct!";
        else
            return "Incorrect..";
    }







}

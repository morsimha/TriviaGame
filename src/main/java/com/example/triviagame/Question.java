package com.example.triviagame;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question;
    private ArrayList<String> shuffledAnswers = new ArrayList<String>();
    private int score = 0;
    private String correctAns;


    public void resetGame(){
        score = 0;
        correctAns="";
        question="";
        shuffledAnswers.clear();
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(int ind){
        return shuffledAnswers.get(ind);
    }

    public int getScore(){
        return score;
    }

    public void setQuestion(String currQuestion){
        question = currQuestion;
    }

    public void setShuffledAnswers(ArrayList<String> answers){
        correctAns = answers.get(0);
        Collections.shuffle(answers);
        shuffledAnswers = answers;
    }

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

    public boolean checkAnswer(String answer) {
        return answer.equals(correctAns);
    }







}

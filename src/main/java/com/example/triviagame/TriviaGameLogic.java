package com.example.triviagame;

import java.util.ArrayList;

public class TriviaGameLogic {

    private int score;
    private int correctAns;
    private boolean correctGuess;
//    private int triesLeft = TRIES;

    public void resetGame() {
        score = 0;
        correctAns = 0;

    }

//    public String getLetters(){
//        if (guesses.size() == 0)
//            return "";
//        return guesses.toString();
//    }
//
//    public String getFullWord(){
//        return fullWord;
//    }
//    public String getGuess(){
//        return currGuess;
//    }

//    public int getTriesLeft(){
//        return triesLeft;
//    }

    public String isCorrectGuess() {
        if (correctGuess)
            return "Great Guess!";
        else
            return "Wrong guess..";
    }

    public String finalMessage(boolean win) {
        if (win)
            return "Congrats!";
        else
            return "Almost..";
    }


//    public void setFullWord(String word){
//        fullWord = word;
//    }
//    public void prepWordLength(int len) {
//        for (int i = 0; i < len; i++)
//            currGuess += "_";
//    }

//    public void checkAnswer(String guess) {
//        correctGuess = false;
//        guesses.add(guess);
//        char letter = guesses.get(guesses.size() - 1).charAt(0);
//        for (int i = 0; i < fullWord.length(); i++) {
//            if (fullWord.charAt(i) == letter) {
//                currGuess = currGuess.substring(0, i) + letter + currGuess.substring(i + 1);
//                correctGuess = true;
//            }
//        }
//        if (!correctGuess)
//            triesLeft--;
//    }

//    public boolean checkValidity(String guess) {
//        boolean validGuess = true;
//        if (guess.length() == 1 && guess.matches("[a-zA-Z]+")) { // if its valid, check it didn't show yet
//            for (String g : guesses)
//                if (guess.equals(g)) {
//                    validGuess = false;
//                    return validGuess;
//                }
//        }
//        else
//            validGuess = false;
//
//        return validGuess;
//    }

//    public boolean checkWin() {
//        return fullWord.equals(currGuess);
//    }
//
//
//    public void setGuess(String fullWord) {
//        currGuess = fullWord;
//    }
//}


}

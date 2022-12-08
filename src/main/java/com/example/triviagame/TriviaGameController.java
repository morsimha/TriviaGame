package com.example.triviagame;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class TriviaGameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Canvas cnvs;

    private GraphicsContext gc;
    private Questions que;
    private TriviaGameLogic game;
    //  private HangManBody body;
    private int drawCounter;
    private boolean finished;
    private boolean win;


    public void initialize() throws FileNotFoundException {
        que = new Questions();
        game = new TriviaGameLogic();
        //   body = new HangManBody();
        gc = cnvs.getGraphicsContext2D();
        gc.setLineWidth(5);
        que.parseQuestions();
//        body.build();
//        initGame();
    }

    @FXML
    private void goBtnPressed() {
//        String guess = guessField.getText();
//        if (game.checkValidity(guess))
//            runGame(guess);
//        else
//            JOptionPane.showMessageDialog(null, "Please enter one alphabetic character only!\nAlso, make sure you didnt try it yet.", "Error", JOptionPane.ERROR_MESSAGE);
//        guessField.clear();
//
//        if (game.getTriesLeft() == 0) {
//            JOptionPane.showMessageDialog(null, "Game Over!\nYou have passed the guesses limit.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
//            finishGame();
//        }
//        else if (game.checkWin()) {
//            win = true;
//            finishGame();
//        }
    }

    private void initGame() {
//        gc.clearRect(0, 0, cnvs.getWidth(), cnvs.getHeight());
//        finished = false;
//        win = false;
//        finishScene();
//        drawCounter = 0;
//        game.setFullWord(dict.generateWord());
//        game.prepWordLength(game.getFullWord().length());
//        updateLabels();
    }
}
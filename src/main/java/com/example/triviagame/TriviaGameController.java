package com.example.triviagame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.FileNotFoundException;

public class TriviaGameController {
    @FXML
    private RadioButton ansA;

    @FXML
    private RadioButton ansB;

    @FXML
    private RadioButton ansC;

    @FXML
    private RadioButton ansD;

    @FXML
    private Button AnsBtn;

    @FXML
    private Canvas cnvs;

    @FXML
    private Label questionLabel;

    private GraphicsContext gc;
    private Questions que;
    private TriviaGameLogic game;
    //  private HangManBody body;
    private int drawCounter;
    private boolean finished;
    private boolean win;
    final ToggleGroup group = new ToggleGroup();


    public void initialize() throws FileNotFoundException {
        que = new Questions();
        game = new TriviaGameLogic();
        //   body = new HangManBody();
        gc = cnvs.getGraphicsContext2D();
        gc.setLineWidth(5);
        que.parseQuestions();
//        body.build();
//        initGame();
        ansA.setToggleGroup(group);
        ansB.setToggleGroup(group);
        ansC.setToggleGroup(group);
        ansD.setToggleGroup(group);

    }

    @FXML
    void ansAPressed(ActionEvent event) {

    }

    @FXML
    void ansBPressed(ActionEvent event) {

    }

    @FXML
    void ansCPressed(ActionEvent event) {

    }

    @FXML
    void ansDPressed(ActionEvent event) {

    }

    @FXML
    void ansBtnPressed(ActionEvent event) {
        System.out.println(group.getSelectedToggle()==ansC);


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
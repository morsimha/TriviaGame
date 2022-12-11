package com.example.triviagame;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.*;

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
    private Label questionLabel;

    @FXML
    private Label greetLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label finalScoreLabel;

    @FXML
    private AnchorPane triviaPane;
    @FXML
    private AnchorPane finishPane;
    @FXML
    private ToggleGroup answers;

    private QuestionsReserve trivia;
    private Question game;

    private boolean right;
    private boolean firstRound = true;
    private FadeTransition fadeIn = new FadeTransition(Duration.millis(1000));


    public void initialize() {
        trivia = new QuestionsReserve();
        trivia.parseQuestions();
        trivia.randomizeQuestion();
        game = new Question();
        game.setQuestion(trivia.getQuestion());
        game.setShuffledAnswers(trivia.getAnswers());
        updateLabels();
        firstRound = false;
        initFadeAnimation();

    }

    @FXML
    private void ansBtnPressed() {
        try {
            RadioButton ans = (RadioButton) answers.getSelectedToggle();
            right = game.checkAnswer(ans.getText());
            game.updateScore(right);
            ans.setSelected(false);
            try {
                game.setQuestion(trivia.getQuestion());
                game.setShuffledAnswers(trivia.getAnswers());
                updateLabels();
            } catch (IndexOutOfBoundsException e) {
                updateFinishLabels();
            }
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Please select one answer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    private void restartPressed() {
        updateFinishLabels();
    }
    @FXML
    private void yesBtnPressed() {
        game.resetGame();
        trivia.resetQuestions();
        trivia.randomizeQuestion();
        game.setQuestion(trivia.getQuestion());
        game.setShuffledAnswers(trivia.getAnswers());
        firstRound = true;
        updateNewGameLabels();
        updateLabels();
    }
    @FXML
    private void exitBtnPressed() {
        Platform.exit();
        JOptionPane.showMessageDialog(null, "Good Bye!", "GoodBye", JOptionPane.INFORMATION_MESSAGE);
    }

    private void initFadeAnimation() {
        fadeIn.setNode(triviaPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
    }


    private void updateLabels() { //TODO: can add buttons to list and for loop on it.
        int index = 0;
        questionLabel.setText(game.getQuestion());
        ansA.setText(game.getAnswer(index++));
        ansB.setText(game.getAnswer(index++));
        ansC.setText(game.getAnswer(index++));
        ansD.setText(game.getAnswer(index));

        if (firstRound)
            firstRound = false;
        else { //every round beside the first.
            greetLabel.setText(game.greetMessage(right));
            greetLabel.setVisible(true);
            scoreLabel.setText(game.getScore() + "");
            fadeIn.playFromStart();

        }
    }

    private void updateFinishLabels(){
        finalScoreLabel.setText(game.getScore() + "");
        finishPane.setVisible(true);
        triviaPane.setVisible(false);
        fadeIn.setNode(finishPane);
        fadeIn.playFromStart();
    }

    private void updateNewGameLabels() {
        finishPane.setVisible(false);
        triviaPane.setVisible(true);
        scoreLabel.setText(game.getScore() + "");
        greetLabel.setVisible(false);
        fadeIn.setNode(triviaPane);
        fadeIn.playFromStart();
    }

}
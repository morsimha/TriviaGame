package com.example.triviagame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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

    private QuestionsReserve trivia;
    private Question game;
    private ToggleGroup group;
    private boolean right = false;
    private boolean firstRound = true;
    private boolean lastRound = false;

    public void initialize() {
        group = new ToggleGroup();
        trivia = new QuestionsReserve();
        ansA.setToggleGroup(group);
        ansB.setToggleGroup(group);
        ansC.setToggleGroup(group);
        ansD.setToggleGroup(group);
        initGame();
    }

    @FXML
    private void ansBtnPressed(ActionEvent event) {
        checkAnswer();
        if (trivia.questionsLeft() > 0) {
            game.setQuestion(trivia.getQuestion());
            game.setShuffeldAnswers(trivia.getAnswers());
        } else
            lastRound = true;
        updateLabels();
    }
    @FXML
    private void restartPressed(ActionEvent event) {
        //init game with boolean final round.
        lastRound = true;
        updateLabels();
    }
    @FXML
    private void yesBtnPressed(ActionEvent event) {
        game.resetGame();
        trivia.resetQuestions();
        game.setQuestion(trivia.getQuestion());
        game.setShuffeldAnswers(trivia.getAnswers());
        lastRound = false;
        firstRound = false;
     //   finishPane.setVisible(false);
        updateNewGameLabels();
    }
    @FXML
    private void noBtnPressed(ActionEvent event) {
        Platform.exit();
        JOptionPane.showMessageDialog(null, "Good Bye!", "GoodBye", JOptionPane.INFORMATION_MESSAGE);
    }

    private void initGame() {
        trivia.parseQuestions();
        game = new Question();
        game.setQuestion(trivia.getQuestion());
        game.setShuffeldAnswers(trivia.getAnswers());
        updateLabels();
        firstRound = false;
    }

    private void checkAnswer() {
        if (group.getSelectedToggle() == ansA)
            right = ansA.getText().equals(game.getCorrectAnswer());
        else if (group.getSelectedToggle() == ansB)
            right = ansB.getText().equals(game.getCorrectAnswer());
        else if (group.getSelectedToggle() == ansC)
            right = ansC.getText().equals(game.getCorrectAnswer());
        else if (group.getSelectedToggle() == ansD)
            right = ansD.getText().equals(game.getCorrectAnswer());
        game.updateScore(right);
    }


    private void updateLabels() {
        if (!firstRound) {
            greetLabel.setText(game.greetMessage(right));
            greetLabel.setVisible(true);
            scoreLabel.setText(game.getScore() + "");
        }
        if (!lastRound) {
            int index = 0;
            questionLabel.setText(game.getQuestion());
            ansA.setText(game.getAnswer(index++));
            ansB.setText(game.getAnswer(index++));
            ansC.setText(game.getAnswer(index++));
            ansD.setText(game.getAnswer(index++));
        }
        else{
            finalScoreLabel.setText(scoreLabel.getText());
            finishPane.setVisible(true);
            triviaPane.setVisible(false);

        }
    }

    private void updateNewGameLabels() {
        finishPane.setVisible(false);
        triviaPane.setVisible(true);
        scoreLabel.setText(game.getScore() + "");
        greetLabel.setVisible(false);

    }

// fix greet label and score label updates for round 2 and on
    // randomize questions


}
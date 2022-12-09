package com.example.triviagame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
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

    private GraphicsContext gc;
    private QuestionsReserve que;
    private Question game;
    final ToggleGroup group = new ToggleGroup();
    boolean right = false;
    boolean firstRound = true;
    boolean lastRound = false;



    public void initialize() throws FileNotFoundException {
        que = new QuestionsReserve();
        //   body = new HangManBody();
        ansA.setToggleGroup(group);
        ansB.setToggleGroup(group);
        ansC.setToggleGroup(group);
        ansD.setToggleGroup(group);
        initGame();
    }

    @FXML
    void ansBtnPressed(ActionEvent event) {
        checkAnswer();
        if (que.questionsLeft() > 0) {
            game.setQuestion(que.getQuestion());
            game.setShuffeldAnswers(que.getAnswers());
        } else
            lastRound = true;
        updateLabels();

    }
    @FXML
    void yesBtnPressed(ActionEvent event) {
//        game.resetGame();
//        initGame();
    }
    @FXML
    void noBtnPressed(ActionEvent event) {
        Platform.exit();
        JOptionPane.showMessageDialog(null, "Good Bye!", "GoodBye", JOptionPane.INFORMATION_MESSAGE);
    }


        private void initGame() {
//        gc.clearRect(0, 0, cnvs.getWidth(), cnvs.getHeight());
//        finished = false;
//        win = false;
//        finishScene();
//        drawCounter = 0;
        que.parseQuestions();
        game = new Question();
        game.setQuestion(que.getQuestion());
        game.setShuffeldAnswers(que.getAnswers());
        updateLabels();
        firstRound = false;
    }

    public void checkAnswer() {
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


    public void updateLabels() {
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
}
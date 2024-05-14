package com.example.projectfx;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Thread.sleep;
import static javafx.application.Application.launch;

public class HelloController {
    private static int point = 0;
    private static int userAttemp = 0;
    Random random = new Random();

    private int botNumber = random.nextInt(101);

    private static int userNumber;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button restartButton;

    @FXML
    private Button GuessTheNumberButton;

    @FXML
    private Label Labeltext;

    @FXML
    private Label NumberTextField;

    @FXML
    private TextField TestTextField;
    @FXML
    private Label numberOfAttemps;
    @FXML
    void labelTextOnTestField(ActionEvent event) {

    }

    @FXML
    void setUserNumber(ActionEvent event) {
        String s = NumberTextField.getText();
//        NumberTextField.setText(NumberTextField.getText());
        NumberTextField.setText(s);
        NumberTextField.setStyle("-fx-text-fill: rgb(198, 68, 68);");

    }

    @FXML
    void userAttemp(ActionEvent event) throws InterruptedException {
        if (point == 0) {
            NumberTextField.setText(TestTextField.getText());
            String s = TestTextField.getText();
            if (s.charAt(0) >= 0 && s.charAt(0) <= 100) {
                NumberTextField.setStyle("-fx-text-fill: rgb(198, 68, 68);");
                userNumber = Integer.parseInt(s);
                TestTextField.setText("");
                point=2;
                Labeltext.setText("Тепер спробуй вгадати моє число");
            } else {
                Labeltext.setText("Введи від 0 до 100, а не букви.");
            }
        }
        int randomNumber = getBotAttemp();
        int attemp = Integer.parseInt(TestTextField.getText());

        if (attemp == botNumber){
            Labeltext.setText("Ти виграв. Моє число " + botNumber);
            TestTextField.setText("");
        }else {
            Labeltext.setText("Ти не вгадав. Моє число не " + attemp+ "\n" + "Я думаю твоє число " + randomNumber);
            TestTextField.setText("");
            if (getBotAttemp() == userNumber) {
                Labeltext.setText("Я виграв. Твоє число " + userAttemp);
            }
            }
            userAttemp++;
            numberOfAttemps.setText(String.valueOf(userAttemp));
    }

    public int getBotAttemp(){

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(-4);
        int r = randomNumber();
        if (!hashSet.contains(randomNumber())) {
            hashSet.add(r);
            return randomNumber();
        } else {
            getBotAttemp();
        }
        return r;
    }
    public int randomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(101); // Генерує випадкове число від 0 до 100
        return randomNumber;
    }

    @FXML
    void initialize() {

    }
    @FXML
    void restartProgram(ActionEvent event) {
//        launch();
        Labeltext.setText("Загадай число");
        point =0;
        botNumber = random.nextInt(101);//нове число
        NumberTextField.setText("");
        numberOfAttemps.setText("0");
    }

}

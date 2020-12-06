package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField firstOperand;

    @FXML
    private TextField secondOperand;

    @FXML
    private TextField result;

    @FXML
    private Label err;

    @FXML
    private void calcSum(ActionEvent event)
    {
        setResult('+');
    }

    @FXML
    private void calcSub(ActionEvent event)
    {
        setResult('-');
    }

    @FXML
    private void calcMult(ActionEvent event)
    {
        setResult('*');
    }

    @FXML
    private void calcDiv(ActionEvent event)
    {
        setResult('/');
    }

    private void setResult(Character operator) {
        try {
            this.result.setText("");
            float result = calculate(operator);
            this.result.setText(String.valueOf(result));
            err.setText("");
        } catch (UnluckyException e) {
            err.setText(e.log);
        } catch (NumberFormatException e) {
            err.setText("Wrong Formatting!");
        } catch (Exception e) {
            err.setText("Wrong Operator!");
        }
    }

    private float calculate(Character operator) throws NumberFormatException, UnluckyException, Exception {
        float number1, number2;

        try {
            number1 = Float.parseFloat(firstOperand.getText());
            number2 = Float.parseFloat(secondOperand.getText());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if (number2 == 13) {
            throw new UnluckyException();
        }

        float result = switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> throw new Exception();
        };

        return result;
    }
}

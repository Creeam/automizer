package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import sources.ParantalControl;

import java.net.URL;
import java.util.ResourceBundle;

public class ParantalControlController implements Initializable {

    @FXML private Spinner hourSpinner;
    @FXML private Spinner minuteSpinner;

    private ParantalControl pc;

    public void initialize(URL ur, ResourceBundle rs){
        SpinnerValueFactory valueFactoryH = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        hourSpinner.setValueFactory(valueFactoryH);

        SpinnerValueFactory valueFactoryM = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60, 0);
        minuteSpinner.setValueFactory(valueFactoryM);

        pc = new ParantalControl();
    }

    public void onClickSubmitButton(){
        System.out.println(hourSpinner.getValue());
        System.out.println(minuteSpinner.getValue());
        pc.lockScreen(hourSpinner.getValue().toString(), minuteSpinner.getValue().toString());
    }

}
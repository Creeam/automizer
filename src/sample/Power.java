package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;


public class Power {

    @FXML private Button customTimeButton;
    @FXML private Spinner customTimeSpinner;

    public void start(){
        customTimeSpinner = new Spinner(0,50,35);
    }

    public void onClickMethodCustomTimeButton() {
        System.out.println("CUSTOM TIME");
    }

}
package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PowerController implements Initializable {

    @FXML Spinner customTimeSpinnerH;
    @FXML Spinner customTimeSpinnerM;

    @Override
    public void initialize(URL url, ResourceBundle rb){

        //Spinners
        SpinnerValueFactory valueFactoryH = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        customTimeSpinnerH.setValueFactory(valueFactoryH);

        SpinnerValueFactory valueFactoryM = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60, 0);
        customTimeSpinnerM.setValueFactory(valueFactoryM);
    }

    public void onClickMethodCustomTimeButton() {
        int hour = Integer.parseInt(customTimeSpinnerH.getValue().toString());
        int min = Integer.parseInt(customTimeSpinnerM.getValue().toString());

        shutDown(hour, min);
        System.out.println(hour + " " + min);
    }

    public void shutDown(int hour, int min){
        String command = "shutdown " + "/s " + "/t " + ((hour * 3600) + (min * 60));
        try {
            System.out.println(command);
            Process process = Runtime.getRuntime().exec(command);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onClickMethodMin5(){ shutDown(0, 5); }

    public void onClickMethodMin10(){ shutDown(0, 10);}

    public void onClickMethodMin30(){ shutDown(0, 30);}

    public void onClickMethodHour(){ shutDown(1, 0);}

}
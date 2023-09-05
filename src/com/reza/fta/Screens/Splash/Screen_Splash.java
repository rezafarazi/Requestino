package com.reza.fta.Screens.Splash;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen_Splash implements Initializable
{

    //Global variables
    @FXML
    private Label splash_logo_image;


    //Get start function
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            System.out.println("Salam");

            //Show main screen
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Main/Screen_Main_view.fxml"));
            Parent par=(Parent)loader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(par));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();

            //Hide curent stage
            Stage login_form = (Stage)splash_logo_image.getScene().getWindow();
            login_form.hide();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }




}

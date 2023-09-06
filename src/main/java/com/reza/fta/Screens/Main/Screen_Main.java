package com.reza.fta.Screens.Main;

import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen_Main implements Initializable
{


    //Global variables
    @FXML
    JFXComboBox<String> Method_Select;

    @FXML
    JFXTextField URL_Box;

    @FXML
    Label Response_Text;

    @FXML
    StackPane Dialog_Base;



    //Initlize function start
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Method_Select.getItems().add("Get");
        Method_Select.getItems().add("Post");

    }
    //Initlize function end


    //On click on send request function start
    @FXML
    public void onclicksendrequestbutton(ActionEvent event)
    {
        if(Method_Select.getSelectionModel().getSelectedIndex()>-1)
        {
            if(URL_Box.getText().toString().trim().isEmpty() && URL_Box.getText().toString().contains("http"))
            {
                ShowNotFillURLBOXMethod();
            }
            else
            {
                if(Method_Select.getSelectionModel().getSelectedIndex()==0)
                {
                    ShowFillHeadRequestMethod();
                }
                else if(Method_Select.getSelectionModel().getSelectedIndex()==1)
                {
                    ShowFillHeadAndParametrsRequestMethod();
                }
            }
        }
        else
        {
            ShowNotSelecteMethod();
        }

    }
    //On click on send request function end


    //Show you dont selected item functuin widget start
    private void ShowNotSelecteMethod()
    {
        Dialog_Base.setVisible(true);

        JFXDialogLayout DialogLayout=new JFXDialogLayout();
        DialogLayout.setHeading(new Text("You still dont select request method"));

        //Body
        DialogLayout.setBody(new Text("You still dont selected request method type.\nPlease select it."));

        //Action Buttons
        JFXButton Ok=new JFXButton("OK");
        DialogLayout.setActions(Ok);

        JFXDialog Dialog=new JFXDialog(Dialog_Base,DialogLayout, JFXDialog.DialogTransition.TOP);

        //Actions
        Ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog.close();
            }
        });

        Dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>() {
            @Override
            public void handle(JFXDialogEvent event) {
                Dialog_Base.setVisible(false);
            }
        });

        Dialog.show();
    }
    //Show you dont selected item functuin widget end


    //Show you dont fill url box functuin widget start
    private void ShowNotFillURLBOXMethod()
    {
        Dialog_Base.setVisible(true);

        JFXDialogLayout DialogLayout=new JFXDialogLayout();
        DialogLayout.setHeading(new Text("You still dont fill url box"));

        //Body
        DialogLayout.setBody(new Text("You still dont fill request url box or url not valid.\nPlease fill it."));

        //Action Buttons
        JFXButton Ok=new JFXButton("OK");
        DialogLayout.setActions(Ok);

        JFXDialog Dialog=new JFXDialog(Dialog_Base,DialogLayout, JFXDialog.DialogTransition.TOP);

        //Actions
        Ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog.close();
            }
        });

        Dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>() {
            @Override
            public void handle(JFXDialogEvent event) {
                Dialog_Base.setVisible(false);
            }
        });

        Dialog.show();
    }
    //Show you dont fill url box functuin widget end


    //Show fill request head functuin widget start
    private void ShowFillHeadRequestMethod()
    {
        Dialog_Base.setVisible(true);

        JFXDialogLayout DialogLayout=new JFXDialogLayout();
        DialogLayout.setHeading(new Text("Please fill head value"));

        //Body
        Text text=new Text("Please fill request head value ");
        JFXTextArea Head_Text_Area=new JFXTextArea();

        Head_Text_Area.setPromptText("Head");
        Head_Text_Area.setFocusColor(Paint.valueOf("#4d88f0"));

        VBox LinearLyout=new VBox(
            text,
            Head_Text_Area
        );

        DialogLayout.setBody(LinearLyout);

        //Action Buttons
        JFXButton Done=new JFXButton("Done");
        JFXButton Cancel=new JFXButton("Cancel");
        DialogLayout.setActions(Done,Cancel);
        JFXDialog Dialog=new JFXDialog(Dialog_Base,DialogLayout, JFXDialog.DialogTransition.TOP);

        //Actions
        Done.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog.close();
            }
        });

        Cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog.close();
            }
        });

        Dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>() {
            @Override
            public void handle(JFXDialogEvent event) {
                Dialog_Base.setVisible(false);
            }
        });

        Dialog.show();
    }
    //Show fill request head functuin widget end


    //Show fill request head functuin widget start
    private void ShowFillHeadAndParametrsRequestMethod()
    {
        Dialog_Base.setVisible(true);

        JFXDialogLayout DialogLayout=new JFXDialogLayout();
        DialogLayout.setHeading(new Text("Please fill head and parameters value"));

        //Body
        Text text=new Text("Please fill request head and parametrs value ");
        JFXTextArea Head_Text_Area=new JFXTextArea();
        JFXTextArea Parametrs_Text_Area=new JFXTextArea();

        Head_Text_Area.setPromptText("Head");
        Parametrs_Text_Area.setPromptText("Parametrs");

        Head_Text_Area.setFocusColor(Paint.valueOf("#4d88f0"));
        Parametrs_Text_Area.setFocusColor(Paint.valueOf("#4d88f0"));

        VBox LinearLyout=new VBox(
                text,
                Head_Text_Area,
                Parametrs_Text_Area
        );

        DialogLayout.setBody(LinearLyout);

        //Action Buttons
        JFXButton Done=new JFXButton("Done");
        JFXButton Cancel=new JFXButton("Cancel");
        DialogLayout.setActions(Done,Cancel);
        JFXDialog Dialog=new JFXDialog(Dialog_Base,DialogLayout, JFXDialog.DialogTransition.TOP);

        //Actions
        Done.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog.close();
            }
        });

        Cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog.close();
            }
        });

        Dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>() {
            @Override
            public void handle(JFXDialogEvent event) {
                Dialog_Base.setVisible(false);
            }
        });

        Dialog.show();
    }
    //Show fill request head functuin widget end


}

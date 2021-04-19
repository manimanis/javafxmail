/**
 * Sample Skeleton for 'LoginWindow.fxml' Controller Class
 */

package com.manianis.controllers;

import com.manianis.managers.EmailManager;
import com.manianis.views.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);

	}

	@FXML // fx:id="username"
    private TextField username; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="error"
    private Label error; // Value injected by FXMLLoader

    @FXML
    void btnLoginClicked(ActionEvent event) {
    	viewFactory.showMainWindow();
    	viewFactory.closeStage(stage);
    }

}

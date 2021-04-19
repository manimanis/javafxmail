/**
 * Sample Skeleton for 'MainWindow.fxml' Controller Class
 */

package com.manianis.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.manianis.managers.EmailManager;
import com.manianis.views.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
	}

	@FXML // fx:id="emailTreeView"
    private TreeView<?> emailTreeView; // Value injected by FXMLLoader

    @FXML // fx:id="emailTableView"
    private TableView<?> emailTableView; // Value injected by FXMLLoader

    @FXML // fx:id="emailWebView"
    private WebView emailWebView; // Value injected by FXMLLoader

    @FXML
    void menuAboutClicked(ActionEvent event) {

    }

    @FXML
    void menuCloseClicked(ActionEvent event) {

    }

    @FXML
    void menuOpenClicked(ActionEvent event) {

    }
    
    @FXML
    void menuAddAccountClicked(ActionEvent event) {
    	viewFactory.showLoginWindow();
    }

    @FXML
    void menuOptionsClicked(ActionEvent event) {
    	viewFactory.showOptionsWindow();
    }

   
}

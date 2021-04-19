package com.manianis;
	
import com.manianis.managers.EmailManager;
import com.manianis.views.ViewFactory;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		ViewFactory viewFactory = new ViewFactory(new EmailManager());
		viewFactory.showLoginWindow();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package com.manianis.views;

import java.io.IOException;
import java.util.ArrayList;

import com.manianis.controllers.BaseController;
import com.manianis.controllers.LoginWindowController;
import com.manianis.controllers.MainWindowController;
import com.manianis.controllers.OptionsWindowController;
import com.manianis.managers.EmailManager;
import com.manianis.models.FontSize;
import com.manianis.models.ThemeColor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
	private EmailManager emailManager;
	
	private ThemeColor themeColor = ThemeColor.DEFAULT;
	private FontSize fontSize = FontSize.SMALL;
	private ArrayList<Stage> stages = new ArrayList<>();

	public ViewFactory(EmailManager emailManager) {		
		this.emailManager = emailManager;
	}
	
	public void showLoginWindow() {
		BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
		controller.setStage(initializeStage(controller));
	}
	
	public void showMainWindow() {
		BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
		controller.setStage(initializeStage(controller));
	}
	
	public void showOptionsWindow() {
		BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
		controller.setStage(initializeStage(controller));
	}
	
	private Stage initializeStage(BaseController controller) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
		loader.setController(controller);
		try {
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stages.add(stage);
			return stage;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void closeStage(Stage stage) {
		stages.remove(stage);
		stage.close();
	}

	public ThemeColor getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(ThemeColor themeColor) {
		this.themeColor = themeColor;
	}

	public FontSize getFontSize() {
		return fontSize;
	}

	public void setFontSize(FontSize fontSize) {
		this.fontSize = fontSize;
	}

	public void updateStyles() {
		for (Stage stage : stages) {
			Scene scene = stage.getScene();
			
			scene.getStylesheets().clear();
			scene.getStylesheets().add(getClass().getResource(ThemeColor.getCSSPath(themeColor)).toExternalForm());
			scene.getStylesheets().add(getClass().getResource(FontSize.getCSSPath(fontSize)).toExternalForm());
		}
	}
	
	
}

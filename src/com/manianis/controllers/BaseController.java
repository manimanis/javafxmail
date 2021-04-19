package com.manianis.controllers;

import com.manianis.managers.EmailManager;
import com.manianis.views.ViewFactory;

import javafx.stage.Stage;

public abstract class BaseController {
	
	protected EmailManager emailManager;
	protected ViewFactory viewFactory;
	protected String fxmlName;
	protected Stage stage;
	
	public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super();
		this.emailManager = emailManager;
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}

	public EmailManager getEmailManager() {
		return emailManager;
	}

	public void setEmailManager(EmailManager emailManager) {
		this.emailManager = emailManager;
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public String getFxmlName() {
		return fxmlName;
	}

	public void setFxmlName(String fxmlName) {
		this.fxmlName = fxmlName;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}

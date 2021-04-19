module mailproject {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	
	opens com.manianis;
	opens com.manianis.controllers;
	opens com.manianis.styles;
	opens com.manianis.views;
	opens com.manianis.managers;
}

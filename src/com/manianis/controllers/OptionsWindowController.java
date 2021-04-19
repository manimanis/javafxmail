package com.manianis.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.manianis.managers.EmailManager;
import com.manianis.models.FontSize;
import com.manianis.models.ThemeColor;
import com.manianis.views.ViewFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

public class OptionsWindowController extends BaseController implements Initializable {

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
	}

	@FXML
    // fx:id="fontSizePicker"
    private Slider fontSizePicker; // Value injected by FXMLLoader

    @FXML // fx:id="themePicker"
    private ComboBox<ThemeColor> themePicker; // Value injected by FXMLLoader

    @FXML
    void btnApplyClicked(ActionEvent event) {
    	viewFactory.setThemeColor(themePicker.getValue());
    	viewFactory.setFontSize(FontSize.values()[(int)fontSizePicker.getValue()]);
    	viewFactory.updateStyles();
    }

    @FXML
    void btnCancelClicked(ActionEvent event) {
    	viewFactory.closeStage(stage);
    }
    
    @Override
	public void initialize(URL url, ResourceBundle bundle) {
		setUpThemeColor();
		setUpFontSize();
	}

	private void setUpFontSize() {
		fontSizePicker.setMin(0);
		fontSizePicker.setMax(FontSize.values().length - 1);
		fontSizePicker.setValue(viewFactory.getFontSize().ordinal());
		fontSizePicker.setMajorTickUnit(1);
		fontSizePicker.setMinorTickCount(0);
		fontSizePicker.setBlockIncrement(1);
		fontSizePicker.setSnapToTicks(true);
		fontSizePicker.setShowTickMarks(true);
		fontSizePicker.setShowTickLabels(true);
		fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
			
			@Override
			public String toString(Double dbl) {
				return FontSize.values()[dbl.intValue()].toString();
			}
			
			@Override
			public Double fromString(String arg0) {
				
				return null;
			}
		});
		fontSizePicker.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
				fontSizePicker.setValue(newVal.intValue());
			}
		});
	}
	

	private void setUpThemeColor() {
		themePicker.setItems(FXCollections.observableArrayList(ThemeColor.values()));
		themePicker.setValue(viewFactory.getThemeColor());
	}
}

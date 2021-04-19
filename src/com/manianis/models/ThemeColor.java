package com.manianis.models;

public enum ThemeColor {
	DEFAULT, LIGHT, DARK;

	public static String getCSSPath(ThemeColor themeColor) {
		switch (themeColor) {
		case DEFAULT:
			return "/com/manianis/styles/themeDefault.css";
		case DARK:
			return "/com/manianis/styles/themeDark.css";
		case LIGHT:
			return "/com/manianis/styles/themeLight.css";
		}
		return null;
	}
}

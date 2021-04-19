package com.manianis.models;

public enum FontSize {
	SMALL, MEDIUM, BIG;

	public static String getCSSPath(FontSize fontSize) {
		switch (fontSize) {
		case BIG:
			return "/com/manianis/styles/fontBig.css";
		case MEDIUM:
			return "/com/manianis/styles/fontMedium.css";
		case SMALL:
			return "/com/manianis/styles/fontSmall.css";
		}
		return null;
	}
}

package com.company.utils.enums;

public enum Genre {
    ACTION("action"),
    DRAMA("drama"),
    COMEDY("comedy"),
    ROMANCE("romance");

    private String text;

    Genre(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Genre fromString(String text) {
        for (Genre b : Genre.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
